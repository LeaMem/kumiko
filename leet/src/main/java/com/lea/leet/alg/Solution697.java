package com.lea.leet.alg;


import java.util.HashMap;
import java.util.Map;

public class Solution697 {

    public int findShortestSubArray(int[] nums) {

        if(nums.length <= 1){
            return nums.length;
        }

        Map<Integer, FL> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            if(map.get(nums[i]) == null){
                map.put(nums[i], new FL(i, 1, 1));
            }else{
                FL fl = map.get(nums[i]);
                fl.cnt += 1;
                fl.degree = i - fl.start + 1;
            }
        }

        return map.values()
                .stream()
                .sorted((o1, o2) -> {
                    int re = o2.cnt - o1.cnt;
                    if (re == 0) {
                        return o1.degree - o2.degree;
                    }
                    return re;
                })
                .findFirst()
                .get()
                .degree;

    }

    public static class FL{
        public int start;
        public int degree;
        public int cnt;

        public FL(int start, int degree, int cnt) {
            this.start = start;
            this.degree = degree;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        int shortestSubArray = new Solution697().findShortestSubArray(new int[]{2, 1});
        System.out.println(shortestSubArray);
    }

}
