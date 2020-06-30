package com.lea.leet.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int newIdx = Math.abs(nums[i]) - 1;
            if (nums[newIdx] > 0) {
                nums[newIdx] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }

        return list;
    }

    /*原本的题解*/
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> list = new ArrayList<>();
//
//        boolean[] flags = new boolean[nums.length + 1];
//
//        Arrays.sort(nums);
//
//        for (int num : nums) {
//            flags[num] = true;
//        }
//
//        for(int i = 1; i <= nums.length; i++){
//            if(!flags[i]){
//                list.add(i);
//            }
//        }
//
//        return list;
//
//    }

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        Solution448 solution448 = new Solution448();
        List<Integer> ans = solution448.findDisappearedNumbers(nums);
        for (Integer num : ans) {
            System.out.println(num);
        }

    }

}
