package com.lea.kumiko.midware;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.retry.annotation.EnableRetry;

//https://juejin.im/post/6844903785031008263 guava retry
@SpringBootApplication
@EnableRetry
@EnableAspectJAutoProxy
//@EnableKafka
public class MiddlewareApplication {



    public static void main(String[] args) {
        SpringApplication.run(MiddlewareApplication.class, args);
    }

}
