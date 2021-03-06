package com.lea.leet.alg;

import java.util.*;

public class Solution350 {

    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;

        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums2[j]);
                i++;
                j++;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();

    }

}
