package com.lea.leet.alg;


/**
 * 我好笨哦，往两边找
 */
public class Solution821 {

    public int[] shortestToChar(String S, char C) {

        int[] ans = new int[S.length()];

        for (int i = 0; i < S.length(); i++) {
            ans[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < S.length(); i++) {

            //往左找
            for (int j = i; j >= 0; j--) {
                if (S.charAt(j) == C) {
                    ans[i] = Math.min(i - j, ans[i]);
                    break;
                }
            }

            for (int k = i; k < S.length(); k++) {
                if (S.charAt(k) == C) {
                    ans[i] = Math.min(k - i, ans[i]);
                    break;
                }
            }
        }

        return ans;
    }

}
