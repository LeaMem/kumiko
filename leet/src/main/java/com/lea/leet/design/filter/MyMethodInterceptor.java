package com.lea.leet.design.filter;

/**
 *      到达目标方法之前拦截方法的调用
 */
public interface MyMethodInterceptor {

    /**
     *      类似 InvocationHandler 的 invoke 方法, 通过 invocation 参数驱动责任链
     * @param invocation
     * @return
     * @throws Throwable
     */
    Object invoke(MyMethodInvocation invocation) throws Throwable;

}
