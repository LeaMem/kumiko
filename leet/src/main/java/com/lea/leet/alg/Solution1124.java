package com.lea.leet.alg;

/**
 *      这里的单调栈真的厉害
 *      我似乎才有一点点理解
 */

import java.util.Stack;

public class Solution1124 {

    public int longestWPI(int[] hours) {

        int[] sums = new int[hours.length + 1];

        for (int i = 0; i < hours.length; i++) {
            int it = hours[i];
            if (it > 8) {
                sums[i + 1] = sums[i] + 1;
            } else {
                sums[i + 1] = sums[i] - 1;
            }
        }

        //递减栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < sums.length; i++) {
            if (stack.isEmpty() || sums[stack.peek()] > sums[i]) {
                stack.push(i);
            }
        }

        int max = 0;
        for (int i = sums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && sums[stack.peek()] < sums[i]) {
                max = Math.max(max, i - stack.peek());
                stack.pop();
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] hours = {6, 6, 9};
        Solution1124 solution1124 = new Solution1124();
        int ans = solution1124.longestWPI(hours);
        System.out.println(ans);
    }

}
