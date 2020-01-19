package com.lea.leet.alg;

public class Solution1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        if (start > destination) {
            start = start ^ destination;
            destination = start ^ destination;
            start = start ^ destination;
        }

        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < distance.length; i++) {
            sum += distance[i];
            if (start <= i && i < destination) {
                cnt += distance[i];
            }
        }

        return Math.min(sum - cnt, cnt);

    }


    public static void main(String[] args) {
        int i = new Solution1184().distanceBetweenBusStops(new int[]{7, 10, 1, 12, 11, 14, 5, 0}, 7, 2);
        System.out.println(i);
    }

}
