package com.lea.leet.alg;

public class Solution665 {

    public boolean checkPossibility(int[] nums) {

        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                cnt++;
                if (i >= 2 && nums[i - 2] > nums[i]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i];
                }
            }

        }

        return cnt <= 1;
    }

    public static void main(String[] args) {

//        int[] nums = {3, 4, 2, 3};
//        int[] nums = {4, 2, 3};
        int[] nums = {2, 3, 3, 2, 4};
        Solution665 solution665 = new Solution665();
        boolean res = solution665.checkPossibility(nums);
        System.out.println(res);
    }

}
