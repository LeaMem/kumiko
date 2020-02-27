package com.lea.leet.alg;

public class Solution300 {

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;

        int max = 1;
        for (int i = 1; i < nums.length; i++) {

            int j = i - 1;
            int tmp = 0;
            while (j >= 0) {
                if (nums[j] < nums[i]) {
                    tmp = Math.max(tmp, dp[j]);
                }
                j--;
            }

            dp[i] = Math.max(1, tmp + 1);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {

        int i = new Solution300().lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});

        System.out.println(i);


    }

}
