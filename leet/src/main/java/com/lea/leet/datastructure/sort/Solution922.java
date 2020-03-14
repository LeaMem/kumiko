package com.lea.leet.datastructure.sort;

public class Solution922 {

    public int[] sortArrayByParityII(int[] A) {

        int j = 1;

        for (int i = 0; i < A.length; i += 2) {

            /**
             *      基数
             */
            if (A[i] % 2 == 1) {

                //找到偶数
                while (A[j] % 2 == 1) {
                    j += 2;
                }

                int k = A[i];
                A[i] = A[j];
                A[j] = k;

            }

        }

        return A;
    }

}
