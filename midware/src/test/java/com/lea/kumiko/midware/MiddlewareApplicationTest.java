package com.lea.kumiko.midware;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lea.kumiko.midware.bean.MsgDetectBean;
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

@SpringBootTest
@RunWith(SpringRunner.class)
public class MiddlewareApplicationTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    public void sendMsg() throws JsonProcessingException, InterruptedException {

        MsgDetectBean msgDetectBean = new MsgDetectBean();
        msgDetectBean.setTalker(7777L);
        msgDetectBean.setQwxid(12L);
        msgDetectBean.setFromUser(14L);
        msgDetectBean.setMsgTime(System.currentTimeMillis());
        msgDetectBean.setRuleType(4);
        msgDetectBean.setDetectContent("tet");
        msgDetectBean.setChatMode(2);
        msgDetectBean.setMsgType(4);
        msgDetectBean.setRuleGroupKey("testGroupKey");


        String str = new ObjectMapper().writeValueAsString(msgDetectBean);

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.sendDefault(str);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {

            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println(result);
            }
        });

        TimeUnit.SECONDS.sleep(3L);
    }

}