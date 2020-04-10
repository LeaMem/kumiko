package com.lea.leet.alg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 感觉有点像堆排了
 */
public class Solution1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);

        Map<Integer, Integer> map = new HashMap<>();

        //一开始没有比自己更小的了
        map.put(tmp[0], 0);
        for (int i = 1; i < tmp.length; i++) {
            if (tmp[i] > tmp[i - 1]) {
                //前面有 i 个比自己小
                map.put(tmp[i], i);
            }
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = map.get(nums[i]);
        }

        return ans;

    }

    public static void main(String[] args) {

        int[] nums = {8, 1, 2, 2, 3};
        int[] ints = new Solution1365().smallerNumbersThanCurrent(nums);
        for (int i : ints) {
            System.out.println(i);
        }

    }


}
