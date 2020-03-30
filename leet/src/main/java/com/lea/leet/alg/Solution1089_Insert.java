package com.lea.leet.alg;

public class Solution1089_Insert {

    public void duplicateZeros(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {

                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }

                i += 1;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {0, 4, 1, 0, 0, 8, 0, 0, 3};
        new Solution1089_Insert().duplicateZeros(nums);

        for (int it : nums) {
            System.out.println(it);
        }
    }

}
