package com.lea.leet.alg;



/**
 * 我不会动态规划。。烦死了
 * d(n) = max(d(n-1), d(n-2) + n)
 */
public class Solution198 {

    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= len; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[len];
    }

    public static void main(String[] args) {
        Solution198 solution198 = new Solution198();
        System.out.println(solution198.rob(new int[]{}));
    }

}
