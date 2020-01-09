package com.lea.leet.alg;

public class Solution9 {

    public boolean isPalindrome(int x) {
        String val = String.valueOf(x);
        return val.equals(new StringBuilder(val).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution9().isPalindrome(191));;
    }

}
