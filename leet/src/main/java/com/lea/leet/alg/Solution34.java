package com.lea.leet.alg;

public class Solution34 {

    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = left(nums, target);
        int right = right(nums, target);
        return new int[]{left, right};
    }

    public int left(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                r = mid - 1;
            }
        }

        if (l >= nums.length || nums[l] != target) {
            return -1;
        }

        return l;
    }

    public int right(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            int mid = (l + r) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }

        if (r < 0 || nums[r] != target) {
            return -1;
        }

        return r;
    }

//    public int[] searchRange(int[] nums, int target) {
//
//        if (nums.length == 0) {
//            return new int[]{-1, -1};
//        }
//
//        int l = 0;
//        int r = nums.length - 1;
//
//        while (l < r) {
//            int mid = (l + r) / 2;
//            if (nums[mid] > target) {
//                r = mid;
//            } else if (nums[mid] < target) {
//                l = mid + 1;
//            } else {
//                l = mid;
//                break;
//            }
//        }
//
//        if (nums[l] == target) {
//            int i = l;
//            int j = l;
//            while (i >= 0) {
//                if (nums[i] == target) {
//                    i--;
//                } else {
//                    break;
//                }
//            }
//
//            while (j < nums.length) {
//                if (nums[j] == target) {
//                    j++;
//                } else {
//                    break;
//                }
//            }
//            return new int[]{i + 1, j - 1};
//        }
//
//        return new int[]{-1, -1};
//    }

    public static void main(String[] args) {

        int[] nums = new int[]{1};
        Solution34 solution34 = new Solution34();

        int[] res = solution34.searchRange(nums, 0);
        for (int it : res) {
            System.out.println(it);
        }


    }

}
