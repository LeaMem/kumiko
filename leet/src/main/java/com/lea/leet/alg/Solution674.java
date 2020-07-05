package com.lea.leet.alg;

public class Solution674 {

    public int findLengthOfLCIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int max = 1, tmp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                tmp++;
            } else {
                tmp = 1;
            }
            max = Math.max(max, tmp);
        }

        return max;
    }

    /**
     * 这里可以不用dp
     */
//    public int findLengthOfLCIS(int[] nums) {
//
//        if(nums.length == 0){
//            return 0;
//        }
//
//        int max = 1;
//
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] > nums[i - 1]) {
//                dp[i] = dp[i - 1] + 1;
//            } else {
//                dp[i] = 1;
//            }
//            max = Math.max(dp[i], max);
//        }
//
//        return max;
//    }
    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 4, 7};
        Solution674 solution674 = new Solution674();
        int ans = solution674.findLengthOfLCIS(nums);
        System.out.println(ans);

    }

}
