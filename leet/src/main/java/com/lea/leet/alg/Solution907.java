package com.lea.leet.alg;

import java.util.Stack;

/**
 * https://leetcode.flowerplayer.com/2019/04/12/leetcode-907-sum-of-subarray-minimums-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
 * <p>
 * <p>
 * 终于有点懂了，动态规划版的
 * https://medium.com/@serge45497/leetcode-907-sum-of-subarray-minimums-69d8d64ed7c5
 */
public class Solution907 {

    int MOD = 1000000007;

    public int sumSubarrayMins(int[] A) {

        Stack<Pair> stack = new Stack<>();
        long[] dp = new long[A.length];

        for (int i = 0; i < A.length; i++) {

            while (!stack.isEmpty() && stack.peek().val >= A[i]) {
                Pair pop = stack.pop();
            }

            if (stack.isEmpty()) {
                dp[i] = (i + 1) * A[i];
            } else {
                dp[i] = dp[stack.peek().index] + (i - stack.peek().index) * A[i];
            }

            stack.push(new Pair(A[i], i));

        }

        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += dp[i];
        }

        return (int) (sum % MOD);
    }

    public static class Pair {
        public int val;
        public int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public static void main(String[] args) {

        int[] A = {85, 93, 93, 90};
        Solution907 solution907 = new Solution907();
        int sum = solution907.sumSubarrayMins(A);
        System.out.println(sum);

    }

}
