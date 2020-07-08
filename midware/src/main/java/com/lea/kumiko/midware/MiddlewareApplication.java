package com.lea.kumiko.midware;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
@EnableKafka
public class MiddlewareApplication {



    public static void main(String[] args) {
        SpringApplication.run(MiddlewareApplication.class, args);
    }

}
