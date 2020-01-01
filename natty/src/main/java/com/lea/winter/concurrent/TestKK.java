package com.lea.winter.concurrent;


import java.util.concurrent.TimeUnit;

public class TestKK {


    public synchronized void testWait(){
        System.out.println("准备wait");
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("wait结束");

    }

    public synchronized void testNotify(){
        System.out.println("准备notify");
        this.notify();
        System.out.println("notify结束");
    }

    public static void main(String[] args) throws InterruptedException {

        TestKK testKK = new TestKK();

        new Thread(new Runnable() {
            @Override
            public void run() {
                testKK.testWait();
            }
        }).start();

        TimeUnit.SECONDS.sleep(2);
        testKK.testNotify();

        Thread.currentThread().isInterrupted();

    }

}
