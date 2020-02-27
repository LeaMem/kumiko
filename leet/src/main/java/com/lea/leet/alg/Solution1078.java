package com.lea.leet.alg;

import java.util.ArrayList;
import java.util.List;

public class Solution1078 {

    public int bestSeqAtIndex(int[] height, int[] weight) {

        List<P> list = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            list.add(new P(weight[i], height[i]));
        }

        list.sort((o1, o2) -> {
            int cmp = o1.weight - o2.weight;
            if (cmp == 0) {
                return o1.height - o2.height;
            }
            return cmp;
        });

        //好像还要dp
        int sum = 0;


        return 1;
    }


    public static class P {
        public int weight;
        public int height;

        public P(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }

}
