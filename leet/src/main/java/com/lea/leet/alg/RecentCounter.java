package com.lea.leet.alg;

import java.util.PriorityQueue;

public class RecentCounter {

    private PriorityQueue<Integer> queue;

    public RecentCounter() {
        queue = new PriorityQueue<>();
    }

    public int ping(int t) {

        while (!queue.isEmpty() && t - queue.peek() > 3000) {
            queue.poll();
        }

        queue.add(t);
        return queue.size();
    }

}
