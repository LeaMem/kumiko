package com.lea.leet.alg;

public class Solution1300 {

    public int findBestValue(int[] arr, int target) {

        int max = Integer.MIN_VALUE;

        for (int it : arr) {
            max = Math.max(max, it);
        }

        int l = 0;
        int r = max;


        while (l < r) {

            int mid = (l + r) / 2;

            int sum = sumIt(arr, mid);

            if (sum > target) {
                r = mid;
            } else {
                l = mid + 1;
            }

        }

        if (Math.abs(sumIt(arr, l - 1) - target) <= Math.abs(sumIt(arr, l) - target)) {
            return l - 1;
        }

        return l;
    }

    public int sumIt(int[] arr, int val) {
        int sum = 0;
        for (int it : arr) {
            if (it > val) {
                it = val;
            }
            sum += it;
        }

        return sum;
    }

    public static void main(String[] args) {

        Solution1300 solution1300 = new Solution1300();
        int bestValue = solution1300.findBestValue(new int[]{4, 9, 3}, 10);
        System.out.println(bestValue);


    }

}
