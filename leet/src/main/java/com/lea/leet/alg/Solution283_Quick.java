package com.lea.leet.alg;

public class Solution283_Quick {

    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int i = 0;
        int j = 0;

        //看题解好像是模拟快排的思想
        while(i < nums.length){

            if(nums[i] != 0){
                //交换i, j的值
                int k = nums[i];
                nums[i]= nums[j];
                nums[j] = k;
                j++;
            }
            i++;
        }

    }

}
