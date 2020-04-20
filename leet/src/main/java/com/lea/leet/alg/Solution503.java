package com.lea.leet.alg;

import java.util.LinkedList;

public class Solution503 {

    public int[] nextGreaterElements(int[] nums) {

        LinkedList<Integer> stack = new LinkedList<>();

        int[] res = new int[nums.length];

        /**
         *      递增的栈
         */
        for (int i = 2 * nums.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && nums[i % nums.length] >= stack.peek()) {
                stack.poll();
            }

            int ans = stack.isEmpty() ? -1 : stack.peek();
            res[i % nums.length] = ans;

            stack.push(nums[i % nums.length]);

        }

        return res;

    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};
        Solution503 solution503 = new Solution503();

        int[] ints = solution503.nextGreaterElements(nums);
        for (int it : ints) {
            System.out.println(it);
        }

    }

}
