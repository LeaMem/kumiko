package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Solution988 {

    public String smallestFromLeaf(TreeNode root) {
        return null;
    }


    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                while(true){

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.interrupted();
                        System.out.println("我被中断了");
                        break;
                    }

                }

            }

        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(runnable);


        executorService.shutdownNow();

        while(!executorService.isTerminated()){
            System.out.println("未关闭");
        }

        System.out.println(executorService.isTerminated());

        Thread.currentThread().join();

    }

}
