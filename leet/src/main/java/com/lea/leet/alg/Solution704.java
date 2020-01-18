package com.lea.leet.alg;

public class Solution704 {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int middle = (left + right) / 2;

        while (left <= right) {

            if (nums[middle] > target) {
                right = middle - 1;

            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }

            middle = (left + right) / 2;

        }


        return -1;
    }

    public static void main(String[] args) {
        int k = new Solution704().search(new int[]{-1,0,3,5,9,12}, 9);

        System.out.println(k);
    }
}
