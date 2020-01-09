package com.lea.leet.alg;

import java.util.PriorityQueue;


public class KthLargest {

    PriorityQueue<Integer> queue;

    int k;

    public KthLargest(int k, int[] nums) {

        queue = new PriorityQueue<>(Integer::compareTo);
        this.k = k;

        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {

        if (queue.size() < k) {
            queue.add(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.add(val);
        }

        return queue.peek();
    }

}
