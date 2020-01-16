package com.lea.leet.alg;

import java.util.Arrays;

public class Solution268 {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i != nums[i]){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {

        int i = new Solution268().missingNumber(new int[]{0});

        System.out.println(i);
    }

}
