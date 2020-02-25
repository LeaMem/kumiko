package com.lea.leet.alg;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *      我这里用的是 最小堆
 *      但是听 老丢 说，最优解是 快排变种，只排第k个
 */
public class Solution215 {

    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> deque = new PriorityQueue<>();

        for (int it : nums) {
            if (deque.size() < k) {
                deque.add(it);
            } else {
                int least = deque.peek();
                if (least < it) {
                    deque.remove();
                    deque.add(it);
                }
            }
        }

        return deque.peek();
    }

    public static void main(String[] args) {
        System.out.println(new Solution215().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

}
