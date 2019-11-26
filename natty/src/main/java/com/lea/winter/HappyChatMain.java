package com.lea.winter;


import com.lea.winter.util.Constants;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HappyChatMain {

    public static void main(String[] args) {
        final HappyChatServer server = new HappyChatServer(Constants.DEFAULT_PORT);
        server.init();
        server.start();

        //注册进程钩子，在 JVM 进程关闭前释放资源
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                server.shutdown();
                log.warn(">>> JVM shutdown");
                System.exit(0);
            }
        });
    }

}
