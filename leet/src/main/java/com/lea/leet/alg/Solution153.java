package com.lea.leet.alg;

import java.util.Arrays;

public class Solution153 {

    public int findMin(int[] nums) {

        if (nums.length == 1 || nums[nums.length - 1] > nums[0]) {
            return nums[0];
        }

        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            //升序
            if (nums[mid] >= nums[0]) {
                l = l + 1;
            } else {
                r = mid;
            }
        }

        return nums[l];
    }


    public static void main(String[] args) {
        int min = new Solution153().findMin(new int[]{2, 1});
        System.out.println(min);
    }

}
