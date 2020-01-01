package com.lea.winter.concurrent;

import java.util.concurrent.TimeUnit;

public class WaitNotifyCase {

    public static void main(String[] args) {

        final Object lock = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");

                synchronized (lock){
                    try{
                        System.out.println("thread a get lock");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("thread a do wait method");
                        lock.wait();
                        System.out.println("wait end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread B is waiting to get lock");
                synchronized (lock){
                    System.out.println("thread B is get lock");
                    try{
                        System.out.println("thread B going to sleep");
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println("thread B sleep over");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                    System.out.println("我还占着锁吗");
                    System.out.println("thread b do notify method");
                }
            }
        }).start();

    }

}
