package com.lea.leet.alg;


/**
 * 之前有一题类似
 * 环形列表
 */
public class Solution287 {

    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {

        int duplicate = new Solution287().findDuplicate(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1});

        System.out.println(duplicate);

    }

}
