package com.lea.leet.alg;

import java.util.*;

public class Solution1054 {

    public int[] rearrangeBarcodes(int[] barcodes) {

        int[] ans = new int[barcodes.length];

        Map<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            Integer cnt = map.getOrDefault(barcode, 0);
            cnt++;
            map.put(barcode, cnt);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.value - o1.value;
            }
        });
        for (Integer key : map.keySet()) {
            queue.add(new Pair(key, map.get(key)));
        }

        int index = 0;
        while (queue.size() > 1) {
            Pair first = queue.poll();
            Pair second = queue.poll();
            ans[index++] = first.key;
            ans[index++] = second.key;
            first.value--;
            second.value--;
            if (first.value > 0) {
                queue.add(first);
            }
            if (second.value > 0) {
                queue.add(second);
            }
        }

        if (!queue.isEmpty()) {
            Pair pair = queue.poll();
            while (pair.value > 0) {
                ans[index++] = pair.key;
                pair.value--;
            }
        }

        return ans;

    }

    public static class Pair {
        public int key;
        public int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        int[] barcodes = {5, 7, 5, 7, 5, 7, 5, 7, 8, 8};
        Solution1054 solution1054 = new Solution1054();
        int[] ans = solution1054.rearrangeBarcodes(barcodes);
        for (int it : ans) {
            System.out.println(it);
        }

    }

}
