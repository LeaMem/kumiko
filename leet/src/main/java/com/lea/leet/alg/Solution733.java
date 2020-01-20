package com.lea.leet.alg;

import java.util.LinkedList;

public class Solution733 {

    /**
     *      看大佬都是用的递归，我却没有想到
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int preColor = image[sr][sc];
        if (preColor == newColor) {
            return image;
        }
        LinkedList<TK> queue = new LinkedList<>();
        queue.add(new TK(sr, sc));

        while (!queue.isEmpty()) {

            TK tmp = queue.pop();

            int x = tmp.x;
            int y = tmp.y;

            image[y][x] = newColor;

            //上
            if (y > 0 && image[y - 1][x] == preColor) {

                queue.push(new TK(y - 1, x));
            }

            //下
            if (y < image.length - 1 && image[y + 1][x] == preColor) {
                queue.push(new TK(y + 1, x));
            }

            //左
            if (x > 0 && image[y][x - 1] == preColor) {
                queue.push(new TK(y, x - 1));
            }

            //右
            if (x < image[y].length - 1 && image[y][x + 1] == preColor) {
                queue.push(new TK(y, x + 1));
            }

        }

        return image;
    }

    public static class TK {
        public int x;
        public int y;

        public TK(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

}
