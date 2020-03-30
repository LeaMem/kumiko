package com.lea.leet.alg;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution973 {

    public int[][] kClosest(int[][] points, int K) {

        //第k小的
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] * o2[0] + o2[1] * o2[1] - o1[0] * o1[0] - o1[1] * o1[1] ;
            }
        });

        for (int[] it : points) {

            if (queue.isEmpty() || queue.size() < K) {
                queue.add(it);
            } else {

                int[] peek = queue.peek();
                if (compare(peek, it) > 0) {
                    queue.poll();
                    queue.add(it);
                }

            }

        }

        return queue.toArray(new int[0][]);
    }

    public int compare(int[] first, int[] second) {
        int res =  first[0] * first[0] + first[1] * first[1] - second[0] * second[0] - second[1] * second[1];
        System.out.println(res);
        return res;
    }


    public static void main(String[] args) {
        Solution973 solution973 = new Solution973();

        int[][] params = {
                {3,3},
                {5, -1},
                {-2,4}
        };

        int[][] ints = solution973.kClosest(params, 2);

        System.out.println(ints.length);

    }

}
