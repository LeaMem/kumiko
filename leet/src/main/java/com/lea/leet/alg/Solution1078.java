package com.lea.leet.alg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution1078 {

    public int bestSeqAtIndex(int[] height, int[] weight) {

        List<P> list = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            list.add(new P(weight[i], height[i]));
        }

        list.sort(new Comparator<P>() {
            @Override
            public int compare(P o1, P o2) {
                int cmp = o1.height - o2.height;
                if(cmp == 0){
                    return o2.weight - o1.weight;
                }
                return cmp;
            }
        });

        int[] top = new int[height.length];
        int piles = 0;

        for(int i = 0; i < list.size(); i++){

            P poker = list.get(i);

            int l = 0;
            int r = piles;
            while(l < r){
                int mid = (l + r) / 2;
                if(top[mid] >= poker.weight){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }

            if(l == piles){
                piles++;
            }
            top[l] = poker.weight;
        }


        return piles;
    }

//    public int bestSeqAtIndex(int[] height, int[] weight) {
//
//        List<P> list = new ArrayList<>();
//        for (int i = 0; i < height.length; i++) {
//            list.add(new P(weight[i], height[i]));
//        }
//
//        List<P> first = list.stream()
//                .sorted(Comparator.comparingInt(o -> o.height))
//                .collect(Collectors.toList());
//
//        List<P> second = list.stream()
//                .sorted(Comparator.comparing(o -> o.weight))
//                .collect(Collectors.toList());
//
//
//
//        //好像还要d
//
//
//        return lcs(first, second);
//    }
//
//    public int lcs(List<P> heightList, List<P> weightList){
//
//        int[][] lcs = new int[heightList.size() + 1][weightList.size() + 1];
//
//        for(int i = 1; i <= heightList.size(); i++){
//
//            for(int j = 1; j <= weightList.size(); j++){
//
//                if(heightList.get(i - 1) == weightList.get(j - 1)){
//                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
//                }else{
//                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
//                }
//
//            }
//
//        }
//
//        return lcs[heightList.size()][weightList.size()];
//    }


    public static class P {
        public int weight;
        public int height;

        public P(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }


    public static void main(String[] args) {
        int i = new Solution1078().bestSeqAtIndex(new int[]{8378,8535,8998,3766,648,6184,5506,5648,3907,6773},
                new int[]{9644,849,3232,3259,5229,314,5593,9600,6695,4340});

        System.out.println(i);
    }

}
