package com.lea.leet.alg;

import java.util.Arrays;

public class Solution136 {

    public int singleNumber(int[] nums) {

        Arrays.sort(nums);

        int pre = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {

            if (pre != nums[i]) {
                if (cnt == 1) {
                    return pre;
                } else {
                    cnt = 1;
                    pre = nums[i];
                }
            } else{
                cnt++;
            }
        }

        return pre;
    }

    public static void main(String[] args) {
        int i = new Solution136().singleNumber(new int[]{4, 1, 2, 1, 2});
        System.out.println(i);
    }

}
