package com.lea.leet.forjob;

import java.util.HashMap;
import java.util.Map;

public class ForJob3 {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        ForJob3 forJob3 = new ForJob3();
        int pwwkew = forJob3.lengthOfLongestSubstring(" ");
        System.out.println(pwwkew);
    }
}
