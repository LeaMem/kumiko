package com.lea.tinyioc.aop;

import com.lea.tinyioc.context.ApplicationContext;
import com.lea.tinyioc.context.ClassPathXmlApplicationContext;
import com.lea.tinyioc.test.HelloWorldService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicAopProxy extends AbstractAopProxy implements InvocationHandler {

    public JdkDynamicAopProxy(AdvisedSupport advised) {
        super(advised);
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(), advised.getTargetSource().getTargetClass(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
//        if (advised.getMethodMatcher() != null
//                && advised.getMethodMatcher().matches(method, advised.getTargetSource().getTarget().getClass())) {
//            return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(),
//                    method, args));
//        } else {
//            System.out.println("我们已经是调用的方法了");
//            return method.invoke(advised.getTargetSource().getTarget(), args);
//        }
        System.out.println("开始调用");
        return method.invoke(advised.getTargetSource().getTarget(), args);
    }

    public static void main(String[] args) throws Exception {
//
        HelloWorldService helloWorldService = new HelloWorldService() {
            @Override
            public void helloWorld() {
                System.out.println("kkk");
            }
        };

        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloWorldService.getClass().getInterfaces(), helloWorldService);
        advisedSupport.setTargetSource(targetSource);

        // 设置拦截器  Advice
//        TimerInterceptor timerInterceptor = new TimerInterceptor();
//        advisedSupport.setMethodInterceptor(timerInterceptor);

        // 创建代理 Proxy
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);

//        helloWorldService = (HelloWorldService) jdkDynamicAopProxy.getProxy();
//        helloWorldService.helloWorld();


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");


        HelloWorldService helloWorldService2 = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService2.helloWorld();

    }
}
