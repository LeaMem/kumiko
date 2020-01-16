package com.lea.leet.alg;

import java.util.LinkedList;
import java.util.Queue;

public class Solution994 {

    public int orangesRotting(int[][] grid) {

        //没有腐败的橘子
        Queue<Orange> queue = init(grid);

        //判断是否有橘子
        if (queue.isEmpty()) {

            if (hasOrange(grid)) {
                return -1;
            } else {
                return 0;
            }

        }
        int cnt = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int x = 0; x < size; x++) {

                Orange orange = queue.poll();
                int i = orange.i;
                int j = orange.j;

                //上
                if ((i - 1) >= 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    queue.add(new Orange(i - 1, j));
                }
                //下
                if ((i + 1) < grid.length && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    queue.add(new Orange(i + 1, j));
                }

                //左
                if ((j - 1) >= 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    queue.add(new Orange(i, j - 1));
                }

                //右
                if ((j + 1) < grid[i].length && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    queue.add(new Orange(i, j + 1));
                }
            }

            cnt++;
        }

        return !hasOrange(grid) ? cnt - 1 : -1;
    }

    public Queue<Orange> init(int[][] grid) {

        Queue<Orange> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Orange(i, j));
                }
            }
        }
        return queue;
    }

    public boolean hasOrange(int[][] grid) {
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    return true;
                }
            }
        }
        return false;
    }


    public static class Orange {

        int i;
        int j;

        public Orange(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        int[][] oranges = new int[][]{
                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        };
        int cnt = new Solution994().orangesRotting(new int[][]{{1}});
        System.out.println(cnt);
    }
}
