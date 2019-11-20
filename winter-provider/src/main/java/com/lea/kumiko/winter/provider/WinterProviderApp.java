package com.lea.kumiko.winter.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

/**
 * @author leamem
 */
@SpringBootApplication
@EnableDubbo
public class WinterProviderApp {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(WinterProviderApp.class, args);

        new CountDownLatch(1).await();
    }

}
