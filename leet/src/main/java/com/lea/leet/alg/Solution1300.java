package com.lea.leet.alg;

public class Solution1300 {

    public int findBestValue(int[] arr, int target) {

        int max = Integer.MIN_VALUE;

        for (int it : arr) {
            max = Math.max(max, it);
        }

        int l = 0;
        int r = max;

        int diff = target;
        int last = 0;
        while (l < r) {

            int mid = (l + r) / 2;

            int sum = 0;
            for (int it : arr) {
                if (it > mid) {
                    it = mid;
                }
                sum += it;
            }

//            if (sum > target) {
//                r = mid;
//            } else {
//                l = mid + 1;
//            }
//
//            if (Math.abs(sum - target) < diff) {
//                last = mid;
//                diff = Math.abs(sum - target);
//            }

        }

        return last;
    }

    public static void main(String[] args) {

        Solution1300 solution1300 = new Solution1300();
        int bestValue = solution1300.findBestValue(new int[]{4, 9, 3}, 10);
        System.out.println(bestValue);


    }

}
