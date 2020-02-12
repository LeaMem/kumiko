package com.lea.leet.alg;

public class Solution896 {

    public boolean isMonotonic(int[] A) {

        if (A.length <= 1) {
            return true;
        }

        boolean asc = false;
        boolean desc = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                desc = true;
            } else if (A[i] > A[i - 1]) {
                asc = true;
            }
        }

        return !(asc && desc);
    }


}
