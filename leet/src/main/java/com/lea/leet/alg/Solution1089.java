package com.lea.leet.alg;

public class Solution1089 {

    public void duplicateZeros(int[] arr) {

        int i = 0;
        while (i < arr.length) {

            if (arr[i] == 0) {

                int j = i + 2;
                if (j < arr.length) {
                    int pre = arr[j - 1];
                    while (j < arr.length) {
                        int tmp = arr[j];
                        arr[j] = pre;
                        pre = tmp;
                        j++;
                    }
                }

                //往后写1
                if (i < arr.length - 1) {
                    arr[i + 1] = 0;
                    i += 2;
                    continue;
                }
            }

            i++;
        }

    }

    public static void main(String[] args) {
        int[] nums = {0, 4, 1, 0, 0, 8, 0, 0, 3};
        new Solution1089().duplicateZeros(nums);

        for (int it : nums) {
            System.out.println(it);
        }
    }

}
