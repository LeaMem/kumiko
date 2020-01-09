package com.lea.leet.alg;

public class Solution53 {

    public int maxSubArray(int[] nums) {

        int sum = 0;
        int cus = 0;

        for (int num : nums) {
            cus = Math.max(cus + num, num);
            sum = Math.max(cus, sum);
        }

        return sum;
    }


    public static void main(String[] args) {
        Solution53 solution = new Solution53();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
