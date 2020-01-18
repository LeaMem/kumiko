package com.lea.leet.alg;

public class Solution383 {

    public boolean canConstruct(String ransomNote, String magazine) {

        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        int[] kitty = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            if (i < ransomNote.length()) {
                kitty[ransomNote.charAt(i) - 'a']--;
            }
            kitty[magazine.charAt(i) - 'a']++;
        }

        for (int a : kitty) {
            if (a < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean ans = new Solution383().canConstruct("aa", "aab");
        System.out.println(ans);
    }

}
