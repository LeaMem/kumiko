package com.lea.kumiko.winter.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableDubbo
@EnableAspectJAutoProxy
public class ConsumerApp {

    public static void main(String[] args) {

        SpringApplication.run(ConsumerApp.class, args);

    }

}
