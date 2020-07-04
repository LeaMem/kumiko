package com.lea.leet.alg;

public class Solution997 {

    /**
     * 要多看看图数据结构了
     *
     * @param N
     * @param trust
     * @return
     */
    public int findJudge(int N, int[][] trust) {
        int[] in = new int[N + 1];
        int[] out = new int[N + 1];
        for (int[] it : trust) {
            int start = it[0];
            int end = it[1];
            in[end]++;
            out[start]++;
        }

        for (int i = 1; i <= N; i++) {
            if (in[i] == N - 1 && out[i] == 0){
                return i;
            }
        }
        return -1;
    }

}
