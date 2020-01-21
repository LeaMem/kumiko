package com.lea.leet.alg;

public class Solution53 {

    public int maxSubArray(int[] nums) {

        int curMax = nums[0];
        int sum = nums[0];

        for(int i = 1; i < nums.length; i++){
            curMax = Math.max(curMax + nums[i], nums[i]);
            sum = Math.max(curMax, sum);
        }

        return sum;
    }


    public static void main(String[] args) {
        Solution53 solution = new Solution53();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
