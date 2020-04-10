package com.lea.leet.alg;

import java.util.Arrays;

public class Solution821_DoubleP {

    public int[] shortestToChar(String S, char C) {

        int[] ans = new int[S.length()];

        int s = S.indexOf(C);
        int f = s;

        for (int i = 0; i < S.length(); i++) {

            if (S.charAt(i) == C) {
                s = f;
                f = S.indexOf(C, f + 1);
            }

            ans[i] = Math.min(Math.abs(f - i), Math.abs(s - i));
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "loveleetcode";

        int[] es = new Solution821_DoubleP().shortestToChar(str, 'e');
        Arrays.stream(es)
                .forEach(System.out::println);
    }


}
