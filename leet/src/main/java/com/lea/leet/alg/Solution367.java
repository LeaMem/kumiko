package com.lea.leet.alg;

public class Solution367 {

    public boolean isPerfectSquare(int num) {

        long l = 0;
        long r = num;
        while (l < r) {
            long mid = (l + r) / 2;
            if (num == mid * mid) {
                return true;
            } else if (num < mid * mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l * l == num;
    }


    public static void main(String[] args) {
        boolean perfectSquare = new Solution367().isPerfectSquare(2147483647);
        System.out.println(perfectSquare);
    }
}
