package com.lea.kumiko.midware.others.customTest.spi;

public class SayBye implements Say{
    @Override
    public void say() {
        System.out.println("bye");
    }
}
