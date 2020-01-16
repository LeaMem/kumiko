package com.lea.leet.alg;

public class Solution942 {

    public int[] diStringMatch(String S) {

        int n = S.length();
        int[] ans = new int[n + 1];

        int min = 0;
        int max = n;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                ans[i] = min;
                min++;
            } else {
                ans[i] = max;
                max--;
            }
        }

        ans[n] = max;

        return ans;
    }

    public static void main(String[] args) {

        int[] ans = new Solution942().diStringMatch("IDID");
        System.out.println(ans);

    }
}
