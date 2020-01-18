package com.lea.leet.alg;

import java.util.HashSet;
import java.util.Set;

public class Solution961 {

    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (set.contains(a)) {
                return a;
            }
            set.add(a);
        }
        return 0;
    }

}
