package com.lea.leet.alg;

public class Solution33 {

    public int search(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;

        /**
         *      这里是看别人提交的答案的
         *
         */
        while (l <= r) {

            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[l]) {
                //升序
                //往左边找
                if (target >= nums[l] && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

            } else {

                //中间断了
                /**
                 *      这里是升序，往右边找
                 */
                if (target >= nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {

        Solution33 solution33 = new Solution33();
        int rotation = solution33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println(rotation);

    }

//    public int search(int[] nums, int target) {
//
//        if (nums.length == 0) {
//            return -1;
//        }
//
//        int index = findRo(nums);
//
//        int left = find(nums, 0, index - 1, target);
//
//        return left >= 0 ? left : find(nums, index, nums.length - 1, target);
//    }
//
//    public int find(int[] nums, int l, int r, int target) {
//
//        if (l < 0) {
//            return -1;
//        }
//
//        while (l < r) {
//            int mid = (l + r) / 2;
//            if (nums[mid] > target) {
//                r = mid;
//            } else if (nums[mid] < target) {
//                l = mid + 1;
//            } else {
//                return mid;
//            }
//        }
//
//        return nums[l] == target ? l : -1;
//    }
//
//    public int findRo(int[] nums) {
//        if (nums.length == 1 || nums[nums.length - 1] > nums[0]) {
//            return 0;
//        }
//
//        int l = 0;
//        int r = nums.length - 1;
//        while (l < r) {
//            int mid = (l + r) / 2;
//            if (nums[mid] >= nums[0]) {
//                l = l + 1;
//            } else {
//                r = mid;
//            }
//        }
//
//        return l;
//    }




}
