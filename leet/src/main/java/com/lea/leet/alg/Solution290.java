package com.lea.leet.alg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution290 {

    public boolean wordPattern(String pattern, String str) {
        String[] strList = str.split("\\s+");
        if (pattern.length() != strList.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            //不包含
            if (!map.containsKey(c)) {
                if (set.contains(strList[i])) {
                    return false;
                }
                map.put(c, strList[i]);
                set.add(strList[i]);
            } else {
                if (!map.get(c).equals(strList[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean res = new Solution290().wordPattern("abba", "dog dog dog dog");
        System.out.println(res);
    }

}
