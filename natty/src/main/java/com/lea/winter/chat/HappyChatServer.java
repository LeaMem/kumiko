package com.lea.winter.chat;

import com.lea.winter.chat.core.BaseServer;
import com.lea.winter.chat.handler.MessageHandler;
import com.lea.winter.chat.handler.UserAuthHandler;
import com.lea.winter.chat.handler.UserInfoManager;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class HappyChatServer extends BaseServer {

    private ScheduledExecutorService executorService;

    public HappyChatServer(int port) {
        this.port = port;
        executorService = Executors.newScheduledThreadPool(2);
    }

    @Override
    public void start() {
        b.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .localAddress(new InetSocketAddress(port))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline()
                                //这个是啥意思，所有的操作都再这里吗
                                .addLast(
                                        defaultEventLoopGroup,
                                        new HttpServerCodec(), //请求解码器
                                        new HttpObjectAggregator(65536), //将多个消息转换成单一的消息对象
                                        new ChunkedWriteHandler(), //支持异步发送大的码流，一般用户发送文件流
                                        new IdleStateHandler(60, 0, 0), //检测链路是否未空读闲
                                        new UserAuthHandler(),  //处理握手和验证
                                        new MessageHandler()
                                );
                    }
                });
        try{
            cf = b.bind().sync();
            InetSocketAddress addr = (InetSocketAddress) cf.channel().localAddress();
            log.info("WebSocketServer start success, port is: {}", addr.getPort());

            //定时扫描所有的 Channel, 关闭失效的 Channel
            executorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    log.info("scanNotActiveChannel --------");
                    UserInfoManager.scanNotActiveChannel();
                }
            }, 3, 60, TimeUnit.SECONDS);

            //定时向所有客户端发送ping消息
            executorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    UserInfoManager.broadCastPing();
                }
            }, 3, 50, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            log.error("WebsocketServer start fail,", e);
        }
    }

    @Override
    public void shutdown() {
        if (executorService != null) {
            executorService.shutdown();
        }
        super.shutdown();
    }
}
