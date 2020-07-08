package com.lea.kumiko.midware;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lea.kumiko.bean.MsgDetectBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MiddlewareApplicationTest {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    public void sendMsg() throws JsonProcessingException, InterruptedException {

        MsgDetectBean msgDetectBean = new MsgDetectBean();
        msgDetectBean.setTalker(11L);
        msgDetectBean.setQwxid(12L);
        msgDetectBean.setFromUser(14L);
        msgDetectBean.setMsgTime(System.currentTimeMillis());
        msgDetectBean.setRuleType(4);
        msgDetectBean.setDetectContent("tet");
        msgDetectBean.setChatMode(4);
        msgDetectBean.setMsgType(4);
        msgDetectBean.setRuleGroupKey("testGroupKey");


        String str = new ObjectMapper().writeValueAsString(msgDetectBean);

        ListenableFuture listenableFuture = kafkaTemplate.sendDefault(str);

        TimeUnit.SECONDS.sleep(3L);
    }

}