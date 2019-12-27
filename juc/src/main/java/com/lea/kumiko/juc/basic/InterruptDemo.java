package com.lea.kumiko.juc.basic;

public class InterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println(i++);
                }
            }
        });

        thread.start();


        Thread.sleep(2000L);
        thread.interrupt();
    }
}
