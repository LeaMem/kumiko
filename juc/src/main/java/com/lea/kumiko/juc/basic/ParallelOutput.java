package com.lea.kumiko.juc.basic;

public class ParallelOutput {

    private Integer index;

    public ParallelOutput(Integer index) {
        this.index = index;
    }

    public synchronized void increment() throws InterruptedException {
        while (index < 100) {
            System.out.println("Thread is " + Thread.currentThread().getName() + " " + index);
            index += 1;
            notify();
            wait();
        }
        notify();
    }

    public static void main(String[] args) {

        ParallelOutput parallelOutput = new ParallelOutput(1);

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            parallelOutput.increment();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    parallelOutput.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
