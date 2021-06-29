package com.lea.kumiko.midware.others.customTest.spi;

public class SayHello implements Say{
    @Override
    public void say() {
        System.out.println("hello");
    }
}
