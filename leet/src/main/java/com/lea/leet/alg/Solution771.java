package com.lea.leet.alg;

import java.util.HashSet;
import java.util.Set;

public class Solution771 {

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (Character ch : J.toCharArray()) {
            set.add(ch);
        }
        int sum = 0;
        for (Character ch : S.toCharArray()) {
            if (set.contains(ch)) {
                sum++;
            }
        }
        return sum;
    }

}
