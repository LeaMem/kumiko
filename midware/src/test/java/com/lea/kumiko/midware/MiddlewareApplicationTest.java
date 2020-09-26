package com.lea.kumiko.midware;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.TimeUnit;

/**
 *      1. Spring 源码 https://github.com/seaswalker/spring-analysis
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MiddlewareApplicationTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;



}