package com.lea.leet.alg;

public class Solution96 {

    public int numTrees(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 1;
        ans[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                ans[i] += ans[j - 1] * ans[i - j];
            }
        }
        return ans[n];
    }

    public static void main(String[] args) {

        Solution96 solution96 = new Solution96();
        int ans = solution96.numTrees(3);
        System.out.println(ans);

    }

}
