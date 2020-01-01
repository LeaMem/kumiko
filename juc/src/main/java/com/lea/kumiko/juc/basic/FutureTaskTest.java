package com.lea.kumiko.juc.basic;

import java.util.concurrent.*;

public class FutureTaskTest {

    private static final CyclicBarrier barrier = new CyclicBarrier(5);

    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {

        for(int i = 0; i < 5; i++){
            final String name = "玩家 " + i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(name + "准备就绪");
                    try {
                        Thread.sleep(1000L);
                        barrier.await();
                        System.out.println(name + "进入游戏");
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        barrier.reset();

        for(int i = 0; i < 5; i++){
            final String name = "玩家 " + i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(name + "准备就绪");
                    try {
                        Thread.sleep(1000L);
                        barrier.await();
                        System.out.println(name + "进入游戏");
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }

}
