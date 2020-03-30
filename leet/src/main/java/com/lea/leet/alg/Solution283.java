package com.lea.leet.alg;

public class Solution283 {

    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {

            while (nums[i] == 0 && j > 0) {
                int tmp = nums[i];
                int k = i;
                while (k < j) {
                    nums[k] = nums[k + 1];
                    k++;
                }
                nums[k] = tmp;
                j--;
            }

            i++;
        }
    }

    public static void main(String[] args) {

        int[] nums = {0, 0};
        new Solution283().moveZeroes(nums);

        for (int it : nums) {
            System.out.println(it);
        }

    }

}
