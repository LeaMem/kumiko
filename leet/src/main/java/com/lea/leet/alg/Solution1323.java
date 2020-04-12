package com.lea.leet.alg;

public class Solution1323 {

    public int maximum69Number(int num) {

        StringBuilder builder = new StringBuilder(String.valueOf(num));
        int i = builder.indexOf("6");
        if (i != -1) {
            builder.setCharAt(i, '9');
        }
        return Integer.parseInt(builder.toString());
    }


    public static void main(String[] args) {
        Solution1323 solution1323 = new Solution1323();
        int i = solution1323.maximum69Number(696);
        System.out.println(i);
    }

}
