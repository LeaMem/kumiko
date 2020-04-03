package com.lea.leet.design.filter;


import java.util.List;

/**
 *      https://www.jianshu.com/p/36508cd6decd
 */
public class MyMethodInvocationImpl implements MyMethodInvocation {

    private List<MyMethodInterceptor> interceptorList;

    //被代理的对象
//    private TargetMethod targetMethod;

    /**
     *      当前调用的拦截器索引
     */

    //todo jdk 动态代理
    private int currentIndex = 0;

    @Override
    public Object proceed() throws Throwable {

        /**
         *      索引值从 0 开始递增，如果 currentInterceptorIndex 等于集合大小，说明拦截结束
         */
        if(this.currentIndex == this.interceptorList.size()){
            // return targetMethod.getMethod().invoke(targetMethod.getTarget, targetMethod.getArgs());
            return new Object();
        }

        //一些处理

        //获取下个拦截器
        MyMethodInterceptor methodInterceptor = this.interceptorList.get(this.currentIndex++);

        return methodInterceptor.invoke(this);
    }
}
