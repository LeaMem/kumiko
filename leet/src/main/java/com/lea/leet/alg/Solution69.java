package com.lea.leet.alg;

public class Solution69 {

    public int mySqrt(int x) {
        int k = (int) Math.sqrt(x);
        return k;
    }


    public static void main(String[] args) {
        int i = new Solution69().mySqrt(8);
        System.out.println(i);
    }
}
