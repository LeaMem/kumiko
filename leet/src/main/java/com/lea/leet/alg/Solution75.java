package com.lea.leet.alg;

public class Solution75 {

    /**
     * 这是要我写快拍吗
     *
     * @param nums
     */
    public void sortColors(int[] nums) {

        sort(nums, 0, nums.length - 1);

    }


    public void sort(int[] nums, int l, int r) {

        if (l < r) {
            int partition = partition(nums, l, r);
            sort(nums, l, partition - 1);
            sort(nums, partition + 1, r);
        }

    }

    public int partition(int[] nums, int l, int r) {

        int start = l;
        int tmp = nums[r];
        for (int i = l; i < r; i++) {

            //如果
            if (tmp > nums[i]) {
                int k = nums[i];
                nums[i] = nums[start];
                nums[start] = k;
                start++;
            }
        }

        int k = nums[start];
        nums[start] = tmp;
        nums[r] = k;

        return start;
    }

}
