package com.lea.leet.concurrent;

import java.util.HashMap;
import java.util.Map;

public class Solution242 {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] first = new int[26];
        int[] second = new int[26];

        for (int i = 0; i < s.length(); i++) {
            first[s.charAt(i) - 'a'] += 1;
            second[t.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }

        return true;
    }

}
