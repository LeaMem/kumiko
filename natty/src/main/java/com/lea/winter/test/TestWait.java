package com.lea.winter.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestWait {

    public static Lock lock = new ReentrantLock();

    public synchronized void testWait() throws InterruptedException {
        this.wait();
    }

    public synchronized void testFree(){
        this.notify();
    }


    public static void main(String[] args) throws InterruptedException {

        TestWait testWait = new TestWait();

        Thread k = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("begin");
                    testWait.testWait();
                    System.out.println("wait");
                    Thread.sleep(1000);
                    testWait.testFree();
                    System.out.println("ok");
                } catch (InterruptedException e) {

                }
            }
        });


        k.start();
        Thread.sleep(5000);
    }

}
