package com.lea.leet.design.filter;

public interface MyMethodInvocation {

    /**
     *      进入拦截器中的下一个拦截器，驱动责任链
     */
    Object proceed() throws Throwable;

}
