package com.lea.tinyioc.aop;


import com.lea.tinyioc.HelloWorldService;
import com.lea.tinyioc.context.ApplicationContext;
import com.lea.tinyioc.context.ClassPathXmlApplicationContext;
import org.junit.Test;

public class JdkDynamicAopProxyTest {

    @Test
    public void testInterceptor() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();

//        // 设置被代理对象 JoinPoint
//        AdvisedSupport advisedSupport = new AdvisedSupport();
//        TargetSource targetSource = new TargetSource(HelloWorldService.class, helloWorldService);
//        advisedSupport.setTargetSource(targetSource);
//
//        // 设置拦截器  Advice
//        TimerInterceptor timerInterceptor = new TimerInterceptor();
//        advisedSupport.setMethodInterceptor(timerInterceptor);
//
//        // 创建代理 Proxy
//        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
//        HelloWorldService helloWorldServiceProxy = (HelloWorldService) jdkDynamicAopProxy.getProxy();
//
//        // 基于 AOP 的调用
//        helloWorldServiceProxy.helloWorld();
//        helloWorldServiceProxy.runAway();

    }

}
