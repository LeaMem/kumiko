package com.lea.leet.alg;


public class Solution1011 {

    public int shipWithinDays(int[] weights, int D) {

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int value : weights) {
            sum += value;
            max = Math.max(max, value);
        }

        int l = max;
        int r = sum;

        while (l < r) {

            int capacity = (l + r) / 2;

            int times = 0;
            int d = 1;

            for (int weight : weights) {
                if (times + weight <= capacity) {
                    times += weight;
                } else {
                    times = weight;
                    d++;
                }
            }

            if (d <= D) {
                r = capacity;
            } else {
                l = capacity + 1;
            }

        }

        return l;
    }

    public static void main(String[] args) {

        Solution1011 solution1011 = new Solution1011();
        int i = solution1011.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3);
        System.out.println(i);
    }

}
