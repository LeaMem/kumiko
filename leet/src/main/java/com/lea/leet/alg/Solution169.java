package com.lea.leet.alg;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution169 {

    public int majorityElement(int[] nums) {

        Map<Integer, Long> collect = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long max = 0L;
        int res = 0;

        for(int it : collect.keySet()){
            if(max < collect.get(it)){
                res = it;
                max = collect.get(it);
            }
        }

        return res;
    }

}
