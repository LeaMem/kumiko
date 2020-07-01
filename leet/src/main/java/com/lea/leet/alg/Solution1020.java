package com.lea.leet.alg;

import java.util.*;


/**
 *      这里看的别人的思路，原本我写的是从里往外走，还要记录回溯，防止死循环
 *      参考别人的代码，人家从外往里走，
 */
public class Solution1020 {


    public int numEnclaves(int[][] A) {

        Set<Pair> set = new HashSet<>();


        int count = 0;
        for (int i = 0; i < A.length; i++) {

            for (int j = 0; j < A[i].length; j++) {

                if (A[i][j] == 1) {
                    boolean ans = dfs(A, i, j);
                    if (ans) {
                        count++;
                    }
                }

            }
        }
        return count;
    }

    public boolean dfs(int[][] A, int i, int j) {

        LinkedList<Pair> stack = new LinkedList<>();
        stack.push(new Pair(i, j));

        while (!stack.isEmpty()) {

            Pair pair = stack.pop();
            int x = pair.x;
            int y = pair.y;

            if (A[x][y] != 1) {
                continue;
            }

            if (x == 0 || x == A.length - 1 || y == 0 || y == A[x].length - 1) {
                return true;
            }

            if (x < A.length - 1) {
                if (A[x - 1][y] == 1) {
                    stack.push(new Pair(x - 1, y));
                }
                if (A[x + 1][y] == 1) {
                    stack.push(new Pair(x + 1, y));
                }
            }

            if (y < A[x].length - 1) {
                if (A[x][y - 1] == 1) {
                    stack.push(new Pair(x, y - 1));
                }
                if (A[x][y + 1] == 1) {
                    stack.push(new Pair(x, y + 1));
                }
            }

        }

        return false;
    }

    public static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
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
