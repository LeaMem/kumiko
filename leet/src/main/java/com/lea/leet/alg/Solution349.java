package com.lea.leet.alg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution349 {

    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;

        Set<Integer> set = new HashSet<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums2[j]);
                i++;
                j++;
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        int[] res = new Solution349().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        System.out.println(res);
    }

}
