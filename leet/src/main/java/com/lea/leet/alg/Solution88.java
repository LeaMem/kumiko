package com.lea.leet.alg;

public class Solution88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums2 == null || nums2.length == 0) {
            return;
        }

        int[] ans = new int[m + n + 1];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                ans[k++] = nums1[i++];
            } else {
                ans[k++] = nums2[j++];
            }
        }

        while (i < m) {
            ans[k++] = nums1[i++];
        }
        while (j < n) {
            ans[k++] = nums2[j++];
        }

        if (m + n >= 0) System.arraycopy(ans, 0, nums1, 0, m + n);

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        new Solution88().merge(nums1, 3, nums2, 3);

    }

}
