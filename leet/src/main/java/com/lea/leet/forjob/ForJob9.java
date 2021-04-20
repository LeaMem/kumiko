package com.lea.leet.forjob;

public class ForJob9 {

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int i = 0;
        int j = s.length() - 1;
        while (i != j && i < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        ForJob9 forJob9 = new ForJob9();
        boolean palindrome = forJob9.isPalindrome(11);
        System.out.println(palindrome);
    }

}
