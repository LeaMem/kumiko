package com.lea.kumiko.juc.basic;

import java.util.Arrays;

public class ThreadHappensBefore {

//    public static volatile boolean flag = false;
//
//
//    public static void setFlag() {
//        flag = true;
//    }

    public static Boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("kitty");
            }
        }, "kitty");

        thread.start();

        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));


        Thread.sleep(5000L);


    }

}
