package com.lea.leet.alg;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 快排
 */
public class Solution215Quick {

    public int findKthLargest(int[] nums, int k) {

        int kth = nums.length - k;

        Deque<Record> deque = new LinkedList<>();
        deque.add(new Record(0, nums.length - 1));

        while (!deque.isEmpty()) {

            Record pop = deque.pop();

            int i = pop.start;
            int j = pop.end;
            int tmp = nums[i];

            while (i < j) {

                while (i < j && tmp < nums[j]) {
                    j--;
                }

                if (i < j) {
                    nums[i++] = nums[j];
                }

                while (i < j && tmp > nums[i]) {
                    i++;
                }

                if (i < j) {
                    nums[j--] = nums[i];
                }

            }

            nums[i] = tmp;

            if (i == kth) {
                return nums[kth];
            } else if (i > kth) {
                deque.add(new Record(pop.start, i - 1));
            } else {
                deque.add(new Record(i + 1, pop.end));
            }
        }

        return nums[kth];
    }

    public static class Record {

        public int start;
        public int end;

        public Record(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution215Quick().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
