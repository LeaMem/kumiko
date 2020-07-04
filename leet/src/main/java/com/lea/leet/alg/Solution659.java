package com.lea.leet.alg;

import java.util.*;


/**
 *      这个是看别人写的
 */
public class Solution659 {

    public boolean isPossible(int[] nums) {


        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int it : nums) {

            //判断之前是否有连续的值
            PriorityQueue<Integer> queue = map.get(it - 1);

            int cnt;
            if (queue == null || queue.isEmpty()) {
                cnt = 1;
            } else {
                cnt = queue.poll() + 1;
            }

            if (!map.containsKey(it)) {
                map.put(it, new PriorityQueue<>());
            }

            map.get(it).add(cnt);
        }

        return map.values().stream().flatMap(Collection::stream).noneMatch(it -> it < 3);
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 3, 4, 5};
        Solution659 solution659 = new Solution659();
        boolean possible = solution659.isPossible(nums);
        System.out.println(possible);

    }


}
