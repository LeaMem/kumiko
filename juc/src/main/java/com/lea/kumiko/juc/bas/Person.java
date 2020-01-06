package com.lea.kumiko.juc.bas;

import java.util.concurrent.locks.LockSupport;

public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        String a = new String("A");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("睡觉");
                LockSupport.park(a);
                System.out.println("起床");
                System.out.println("是否中断：" + Thread.currentThread().isInterrupted());
            }
        });
        t.setName("A-Name");
        t.start();
        t.interrupt();
        System.out.println("突然肚子很疼");
    }
}
