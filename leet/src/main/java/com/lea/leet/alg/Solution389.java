package com.lea.leet.alg;


public class Solution389 {

    public char findTheDifference(String s, String t) {

        if (s.length() == 0) {
            return t.charAt(0);
        }

        int k = s.charAt(0) ^ t.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            int tmp = t.charAt(i) ^ s.charAt(i);
            k = k ^ tmp;
        }
        return (char) (k ^ t.charAt(t.length() - 1));
    }

    public static void main(String[] args) {
        char c = new Solution389().findTheDifference("abcd", "abcde");
        System.out.println(c);

        int a = 0;
        int b = 11;
        a = a ^ b;
        System.out.println(a);

    }

}
