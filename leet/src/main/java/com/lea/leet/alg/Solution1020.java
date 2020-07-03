package com.lea.leet.alg;


/**
 * 这里看的别人的思路，原本我写的是从里往外走，还要记录回溯，防止死循环
 * 参考别人的代码，人家从外往里走，
 */
public class Solution1020 {

    public int numEnclaves(int[][] A) {
        int n = A[0].length;
        for (int i = 0; i < A.length; i++) {
            dfs(A, i, 0);
            dfs(A, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(A, 0, j);
            dfs(A, A.length - 1, j);
        }

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int[][] A, int i, int j) {

        //判断是否能够继续走下去
        if (i < 0 || i >= A.length || j >= A[i].length || j < 0 || A[i][j] != 1) {
            return;
        }

        A[i][j] = 0;
        dfs(A, i - 1, j);
        dfs(A, i + 1, j);
        dfs(A, i, j - 1);
        dfs(A, i, j + 1);

    }

    public static void main(String[] args) {

        int[][] A = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        Solution1020 solution1020 = new Solution1020();
        int ans = solution1020.numEnclaves(A);

        System.out.println(ans);

    }

}
