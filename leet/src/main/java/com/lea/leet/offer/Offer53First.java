package com.lea.leet.offer;

public class Offer53First {

    public int missingNumber(int[] nums) {

        int l = 0;
        int r = nums.length;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < mid) {
                l = mid + 1;
            } else if (nums[mid] == mid) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int i = new Offer53First().missingNumber(new int[]{0, 2, 3});
        System.out.println(i);
    }

}
