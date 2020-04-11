package com.lea.leet.alg;

public class Solution1342 {

    public int numberOfSteps(int num) {

        if (num == 0) {
            return 0;
        }

        int n = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            }else{
                num--;
            }
            n++;
        }

        return n;
    }


}
