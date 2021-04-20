package com.lea.leet.forjob;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class ForJob215 {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
        for (int num : nums) {
            if(queue.size() < k){
                queue.add(num);
            }else if(queue.peek() <= num){
                queue.poll();
                queue.add(num);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        ForJob215 forJob215 = new ForJob215();
        int kthLargest = forJob215.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        System.out.println(kthLargest);
    }


}
