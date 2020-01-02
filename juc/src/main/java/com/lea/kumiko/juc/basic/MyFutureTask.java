package com.lea.kumiko.juc.basic;

import java.util.concurrent.*;

public class MyFutureTask {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "kitty";
            }
        });

        try {
            future.get(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }

}
