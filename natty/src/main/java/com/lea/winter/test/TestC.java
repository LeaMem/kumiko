package com.lea.winter.test;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestC {

    private static Lock lock = new ReentrantLock();

    private static int count = 1;

    public static void add(){

        System.out.println("开始的线程是 " + Thread.currentThread().getName());

        lock.lock();

        System.out.println("开始 " + Thread.currentThread().getName());

        boolean flag = new Random().nextBoolean();

        if(flag){
            count++;
        }else{

        }

        System.out.println("结束 " + count + " " + Thread.currentThread().getName());

        lock.unlock();

        System.out.println("结束的线程是 " + Thread.currentThread().getName());

    }

    public static void main(String[] args) {



    }

}
