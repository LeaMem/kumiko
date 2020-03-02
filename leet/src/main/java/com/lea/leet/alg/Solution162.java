package com.lea.leet.alg;

/**
 * 局部递增
 */
public class Solution162 {

    public int findPeakElement(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {

            int mid = (l + r) / 2;

            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }

        }

        return l;
    }

    public static void main(String[] args) {
        int res = new Solution162().findPeakElement(new int[]{1, 2, 3, 1});
        System.out.println(res);
    }

}
