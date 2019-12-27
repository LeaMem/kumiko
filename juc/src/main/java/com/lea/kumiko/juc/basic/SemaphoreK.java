package com.lea.kumiko.juc.basic;

import java.util.concurrent.Semaphore;

public class SemaphoreK {

    private Semaphore semaphore;

    public SemaphoreK(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);



    }
}
