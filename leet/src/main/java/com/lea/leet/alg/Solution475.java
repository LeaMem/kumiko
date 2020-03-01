package com.lea.leet.alg;

import java.util.Arrays;

public class Solution475 {

    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(houses);
        Arrays.sort(heaters);

        int max = Integer.MIN_VALUE;

        for (int house : houses){
            int diff = find(heaters, house);
            max = Math.max(max, diff);
        }

        return max;
    }

    public int find(int[] heaters, int house) {

        int l = 0;
        int r = heaters.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if(heaters[mid] >= house){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        if(l == 0){
            return Math.abs(heaters[l] - house);
        }

        return Math.min(Math.abs(heaters[l] - house), Math.abs(heaters[l - 1] - house));
    }

    public static void main(String[] args) {

        int radius = new Solution475().findRadius(new int[]{5}, new int[]{1,6,7});
        System.out.println(radius);

    }

}
