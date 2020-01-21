package com.lea.leet.alg;

public class Solution1013 {

    public boolean canThreePartsEqualSum(int[] A) {

        int sum = 0;
        for (int a : A) {
            sum += a;
        }

        if (A.length < 3 || sum % 3 != 0) {
            return false;
        }

        int avg3 = sum / 3;

        int i = 0;
        int sumI = 0;
        int j = A.length - 1;
        int sumJ = 0;

        //从左开始
        while (i < A.length && (sumI + A[i]) != avg3) {
            sumI += A[i];
            i++;
        }

        //从右开始
        while (j >= 0 && (sumJ + A[j]) != avg3) {
            sumJ += A[j];
            j--;
        }

        return i < j;

    }

    public static void main(String[] args) {
        boolean ans = new Solution1013().canThreePartsEqualSum(new int[]{3,3,6,5,-2,2,5,1,-9,4});
        System.out.println(ans);
    }

}
