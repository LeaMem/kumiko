package com.lea.winter.chat.handler;

import com.lea.winter.chat.entity.UserInfo;
import com.lea.winter.chat.proto.ChatCode;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

        log.info("messageHandler 在这个线程 [{}]", Thread.currentThread().getName());

        UserInfo userInfo = UserInfoManager.getUserInfo(ctx.channel());
        if(userInfo != null && userInfo.isAuth()){


            //广播返回用户发送的消息文本
//            UserInfoManager.broadcastMess(userInfo.getUserId(), userInfo.getNick(), json.getString("mess"));
        }
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        UserInfoManager.removeChannel(ctx.channel());
        UserInfoManager.broadcastInfo(ChatCode.SYS_USER_COUNT, UserInfoManager.getAuthUserCount());
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("connection error and close the channel", cause);
        UserInfoManager.removeChannel(ctx.channel());
        UserInfoManager.broadcastInfo(ChatCode.SYS_USER_COUNT, UserInfoManager.getAuthUserCount());
    }
}
