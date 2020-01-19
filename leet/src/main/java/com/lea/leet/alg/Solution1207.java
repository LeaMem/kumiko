package com.lea.leet.alg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1207 {

    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int a : arr) {
            if (map.get(a) == null) {
                map.put(a, 1);
            } else {
                int cnt = map.get(a);
                map.put(a, cnt + 1);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int a : map.keySet()) {
            if (set.contains(map.get(a))) {
                return false;
            } else {
                set.add(map.get(a));
            }
        }

        return true;
    }

    public static class KC {
        public int x;
        public int cnt;

        public KC(int x) {
            this.x = x;
        }
    }


}
