package com.lea.leet.design.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Handler implements InvocationHandler {

    private final If original;

    public Handler(If original) {
        this.original = original;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Before");
        method.invoke(original, args);
        System.out.println("After");
        return null;
    }

    public static void main(String[] args) {

        If original = new Original();
        Handler handler = new Handler(original);

        If proxy = (If) Proxy.newProxyInstance(If.class.getClassLoader(),
                original.getClass().getInterfaces(), handler);

        proxy.originMethod("Hallo");

    }
}
