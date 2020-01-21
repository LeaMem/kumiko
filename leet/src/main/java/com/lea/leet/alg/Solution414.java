package com.lea.leet.alg;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution414 {

    /**
     *      做的复杂了
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {

        Set<Integer> set = new HashSet<>();

        PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);

        int max = Integer.MIN_VALUE;

        for (int a : nums) {
            if (set.contains(a)) {
                continue;
            }
            if (queue.size() < 3) {
                queue.offer(a);
            } else if (queue.peek() < a) {
                queue.poll();
                queue.offer(a);
            }
            set.add(a);
            max = Integer.max(max, a);
        }


        return queue.size() >= 3 ? queue.peek() : max;
    }


    public static void main(String[] args) {
        int ans = new Solution414().thirdMax(new int[]{2, 2, 3, 1});
        System.out.println(ans);
    }

}
