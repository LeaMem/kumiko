package com.lea.leet.alg;

import java.util.*;
import java.util.stream.Collectors;

public class Solution1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        Set<Integer> set = Arrays.stream(arr2).boxed().collect(Collectors.toSet());

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int it : arr1) {
            if (set.contains(it)) {
                if (map.containsKey(it)) {
                    map.put(it, map.get(it) + 1);
                } else {
                    map.put(it, 1);
                }
            } else {
                list.add(it);
            }
        }

        int[] ans = new int[arr1.length];

        int index = 0;
        for (int it : arr2) {
            int cnt = map.get(it);
            for (int i = 0; i < cnt; i++) {
                ans[index] = it;
                index++;
            }
        }

        list.sort(Integer::compareTo);
        for (int it : list) {
            ans[index] = it;
            index++;
        }

        return ans;
    }

}
