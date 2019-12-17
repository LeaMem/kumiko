package com.lea.winter.chat.handler;

import com.alibaba.fastjson.JSONObject;
import com.lea.winter.chat.entity.UserInfo;
import com.lea.winter.chat.proto.ChatCode;
import com.lea.winter.chat.util.Constants;
import com.lea.winter.chat.util.NettyUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.*;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class UserAuthHandler extends SimpleChannelInboundHandler<Object> {

    private WebSocketServerHandshaker handshaker;



    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

        log.info("现在是这个线程 [{}]", Thread.currentThread().getName());

        if(msg instanceof FullHttpRequest){
            handleHttpRequest(ctx, (FullHttpRequest) msg);
        }else if (msg instanceof WebSocketFrame){
            handleWebSocket(ctx, (WebSocketFrame) msg);
        }
    }



    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest request){
        if (!request.decoderResult().isSuccess() || !"websocket".equals(request.headers().get("Upgrade"))) {
            log.warn("protobuf don't support websocket");
            ctx.channel().close();
            return;
        }

        WebSocketServerHandshakerFactory handshakerFactory = new WebSocketServerHandshakerFactory(
                Constants.WEBSOCKET_URL, null ,true
        );
        handshaker = handshakerFactory.newHandshaker(request);
        if(handshaker == null){
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
        }else{
            //动态加入 websocket 的编解码处理
            handshaker.handshake(ctx.channel(), request);
            UserInfo userInfo = new UserInfo();
            userInfo.setAddr(NettyUtil.parseChannelRemoteAddr(ctx.channel()));
            //存储已经连接的Channel
            UserInfoManager.addChannel(ctx.channel());
        }
    }


    private void handleWebSocket(ChannelHandlerContext ctx, WebSocketFrame frame){

        //判断是否关闭链路命令
        if(frame instanceof CloseWebSocketFrame){
            //这是啥意思
            handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
            UserInfoManager.removeChannel(ctx.channel());
            return;
        }

        //判断是否是Ping消息
        if(frame instanceof PingWebSocketFrame){
            log.info("ping message: {}", frame.content().retain());
            ctx.writeAndFlush(new PongWebSocketFrame(frame.content().retain()));
            return ;
        }

        //判断是否是 Pong 消息
        if(frame instanceof PongWebSocketFrame){
            log.info("pong message: {}", frame.content().retain());
            ctx.writeAndFlush(new PongWebSocketFrame(frame.content().retain()));
            return ;
        }

        //本程序目前只支持文本消息
        if(!(frame instanceof TextWebSocketFrame)){
            throw new UnsupportedOperationException(frame.getClass().getName() + " frame type not supported");
        }

        String message = ((TextWebSocketFrame) frame).text();
        JSONObject json = JSONObject.parseObject(message);
        int code = json.getInteger("code");
        Channel channel = ctx.channel();
        switch (code){
            case ChatCode.PING_CODE:
            case ChatCode.PONG_CODE:
                UserInfoManager.updateUserTime(channel);
                log.info("receive pong message, address: {}", NettyUtil.parseChannelRemoteAddr(channel));
                return;

            case ChatCode.AUTH_CODE:
                boolean isSuccess = UserInfoManager.saveUser(channel, json.getString("nick"));
                UserInfoManager.sendInfo(channel, ChatCode.SYS_AUTH_STATE, isSuccess);
                if(isSuccess){
                    UserInfoManager.broadcastInfo(ChatCode.SYS_USER_COUNT, UserInfoManager.getAuthUserCount());
                }
                return;
            case ChatCode.MESS_CODE: //普通消息留给 MessageHandler 处理
                break;
            default:
                log.warn("The code [{}}] can't be auth!!!", code);
                return;
        }

        //后续消息交给 MessageHandler 处理
        ctx.fireChannelRead(frame.retain());
    }

}
