package com.lea.leet.design.dynamic_proxy;

public class Original implements If {
    @Override
    public void originMethod(String s) {
        System.out.println(s);
    }
}
