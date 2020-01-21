package com.lea.leet.alg;

public class Solution941 {

    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }

        int i = 1;
        int j = A.length - 2;

        while (i < A.length) {
            if (A[i] <= A[i - 1]) {
                break;
            }
            i++;
        }

        while (j > 0) {
            if (A[j] <= A[j + 1]) {
                break;
            }
            j--;
        }

        i--;
        j++;

        return i == j && i != 0 && j != A.length - 1;
    }

    public static void main(String[] args) {
        boolean ans = new Solution941().validMountainArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(ans);
    }
}
