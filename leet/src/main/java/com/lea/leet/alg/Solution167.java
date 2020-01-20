package com.lea.leet.alg;

import java.util.HashMap;
import java.util.Map;

public class Solution167 {

    public int[] twoSum(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {

            if (map.get(numbers[i]) == null) {
                int rest = target - numbers[i];
                map.put(rest, i);
            } else {
                return new int[]{map.get(numbers[i]) + 1, i + 1};
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {

    }

}
