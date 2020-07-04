package com.lea.leet.alg;

import java.util.*;

public class Solution1042 {

    public int[] gardenNoAdj(int N, int[][] paths) {

        Map<Integer, List<Integer>> pathList = new HashMap<>();
        for (int[] arr : paths) {
            int first = arr[0] - 1;
            int second = arr[1] - 1;
            put(pathList, first, second);
            put(pathList, second, first);
        }

        int[] ans = new int[N];

        for(int i = 0; i < N; i++){
            ans[i] = 1;
        }

        for (Integer key : pathList.keySet()) {

            TreeSet<Integer> colorSet = new TreeSet<>(Arrays.asList(1, 2, 3, 4));

            List<Integer> list = pathList.get(key);

            for (int idx : list) {
                colorSet.remove(ans[idx]);
            }

            ans[key] = colorSet.first();
        }

        return ans;
    }

    private void put(Map<Integer, List<Integer>> pathList, Integer first, Integer second){
        List<Integer> list = pathList.getOrDefault(first, new ArrayList<>());
        list.add(second);
        pathList.put(first, list);
    }

    public static void main(String[] args) {

        int[][] paths = {

                {1, 2},
                {2, 3},
                {3, 1}
        };

        int[] ans = new Solution1042().gardenNoAdj(3, paths);
        for(int it : ans){
            System.out.println(it);
        }

    }

}
