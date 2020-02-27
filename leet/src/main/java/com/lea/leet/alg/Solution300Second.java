package com.lea.leet.alg;


public class Solution300Second {

    public int lengthOfLIS(int[] nums) {

        int[] top = new int[nums.length];

        //牌堆数初始化为 0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {

            //要处理的扑克牌
            int poker = nums[i];

            /**
             *      搜索左侧边界的二分查找
             */
            int left = 0, right = piles;
            while (left < right) {

                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            //没找到合适的牌堆，新建一个堆
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }

        return piles;
    }


    public static void main(String[] args) {

        int i = new Solution300Second().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 21, 18});

        int[] nums = {2, 4, 6, 8, 10};
        int k = 5;

        int left = 0, right = nums.length - 1;

        while (left < right) {

            int mid = (left + right) / 2;
            if (nums[mid] >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        System.out.println(left);

    }

}
