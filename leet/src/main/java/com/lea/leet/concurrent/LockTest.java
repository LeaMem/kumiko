package com.lea.leet.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    public static boolean cal(int x){
        try {
            if(x <= 0){
                throw new RuntimeException();
            }
            return x > 6;
        }finally {
            System.out.println("xxx");
        }
    }

    public LockTest() {
    }

    public static void main(String[] args) throws InterruptedException {
        boolean cal = LockTest.cal(0);
        System.out.println(cal);
    }

}
