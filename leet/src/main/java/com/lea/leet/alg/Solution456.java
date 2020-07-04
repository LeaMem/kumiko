package com.lea.leet.alg;

import java.util.Stack;

/**
 * 又是左前缀
 */
public class Solution456 {

    public boolean find132pattern(int[] nums) {

        if (nums.length < 3) {
            return false;
        }

        int[] min = new int[nums.length];
        min[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }


        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] > min[i]) {

                while (!stack.isEmpty() && stack.peek() <= min[i]) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() < nums[i]) {
                    return true;
                }

                stack.push(nums[i]);

            }

        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, -4, -3};
        Solution456 solution456 = new Solution456();
        boolean result = solution456.find132pattern(nums);
        System.out.println(result);

    }

}
