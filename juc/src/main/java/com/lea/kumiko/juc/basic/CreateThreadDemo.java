package com.lea.kumiko.juc.basic;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CreateThreadDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> future = executorService.submit(new Runnable() {
            @Override
            public void run() {

                Integer result = 100 * 10;
                Thread thread = Thread.currentThread();
                System.out.println(Arrays.toString(thread.getStackTrace()));
            }
        }, 10);

        System.out.println(future.get());
    }

}
