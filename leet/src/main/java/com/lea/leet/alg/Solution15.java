package com.lea.leet.alg;

import java.util.*;

public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int k = 0; k < nums.length; k++) {

            int i = k + 1;
            int j = nums.length - 1;

            if(k > 0 && nums[k] == nums[k - 1]){
                continue;
            }

            while (i < j && i < nums.length - 1) {

                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    i++;
                    while (i < j && nums[i] == nums[i - 1]) {
                        i++;
                    }
                } else if (sum > 0) {
                    j--;
                    while (i < j && nums[j] == nums[j + 1]) {
                        j--;
                    }
                } else {
                    result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    i++;
                    j--;
                    while (i < j && nums[i] == nums[i - 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j + 1]) {
                        j--;
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        Solution15 solution15 = new Solution15();
        List<List<Integer>> lists = solution15.threeSum(nums);
        System.out.println(lists.size());

    }

}
