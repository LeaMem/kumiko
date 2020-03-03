package com.lea.tinyioc.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyProxyFactory {

    public static Object getProxy(Object target) {

        InvocationHandler handler = new MyInvocationHandler(target);

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }

    public static void main(String[] args) {
        Dog target = new GunDog();
        Dog dog = (Dog) MyProxyFactory.getProxy(target);

        dog.info();
        dog.run();
    }

}
