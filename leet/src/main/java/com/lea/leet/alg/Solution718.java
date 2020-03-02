package com.lea.leet.alg;

public class Solution718 {

    public int findLength(int[] A, int[] B) {

        int[] dp = new int[B.length + 1];

        int max = 0;
        for (int value : A) {

            for (int j = B.length - 1; j >= 0; j--) {
                if (value == B[j]) {
                    dp[j + 1] = 1 + dp[j];
                    max = Math.max(dp[j + 1], max);
                } else {
                    dp[j + 1] = 0;
                }
            }

        }

        return max;
    }

    public static void main(String[] args) {
        Solution718 solution718 = new Solution718();

        int length = solution718.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7});
        System.out.println(length);
    }

}
