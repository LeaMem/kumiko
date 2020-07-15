package com.lea.leet.alg;

public class Solution134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {


        for (int i = 0; i < gas.length; i++) {
            int rest = 0;

            for (int j = i; j < gas.length + i; j++) {
                int k = j % gas.length;

                rest += gas[k] - cost[k];

                if (rest < 0) {
                    break;
                }

                if (j == gas.length + i - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] gas = {5, 1, 2, 3, 4};
        int[] cost = {4, 4, 1, 5, 1};


        Solution134 solution134 = new Solution134();
        int ans = solution134.canCompleteCircuit(gas, cost);
        System.out.println(ans);

    }

}
