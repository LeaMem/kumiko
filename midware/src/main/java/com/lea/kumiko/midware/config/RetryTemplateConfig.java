package com.lea.kumiko.midware.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.listener.RetryListenerSupport;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

@Configuration
public class RetryTemplateConfig {

    @Bean
    public RetryTemplate retryTemplate(){

        //可以用builder模式创建

        RetryTemplate retryTemplate = new RetryTemplate();
        //重试时间
        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        //重试次数
        SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
        simpleRetryPolicy.setMaxAttempts(3);

        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);
        retryTemplate.setRetryPolicy(simpleRetryPolicy);
        retryTemplate.registerListener(new RetryListenerSupport(){
            @Override
            public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
                Object attribute = context.getAttribute(RetryContext.NAME);
                System.out.println(attribute);
                System.out.println("start retry");
                return true;
            }

            @Override
            public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
                super.onError(context, callback, throwable);
            }
        });

        return retryTemplate;
    }

}
