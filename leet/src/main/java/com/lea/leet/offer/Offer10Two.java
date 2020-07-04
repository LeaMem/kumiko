package com.lea.leet.offer;

public class Offer10Two {

    public int numWays(int n) {

        if (n == 0) {
            return 1;
        }

        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[0] = 1;

        //dp[i] = dp[i -1] + dp[i-2]
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007L;
        }

        return (int) dp[n];

    }

    public static void main(String[] args) {
        Offer10Two offer10Two = new Offer10Two();
        int ans = offer10Two.numWays(92);
        System.out.println(ans);
    }

}
