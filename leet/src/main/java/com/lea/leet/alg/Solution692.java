package com.lea.leet.alg;

import java.util.*;

public class Solution692 {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        //统计每个单词的次数
        for (String it : words) {
            Integer cnt = map.getOrDefault(it, 0);
            cnt++;
            map.put(it, cnt);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>();

        for (String key : map.keySet()) {
            Integer cnt = map.get(key);
            Pair pair = new Pair(key, cnt);

            if (queue.size() < k) {
                queue.add(pair);
            } else {
                if (queue.peek().compareTo(pair) < 0) {
                    queue.poll();
                    queue.add(pair);
                }
            }
        }

        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll().key);
        }

        Collections.reverse(list);

        return list;
    }

    public static class Pair implements Comparable<Pair> {
        public String key;
        public Integer cnt;

        public Pair(String key, Integer cnt) {
            this.key = key;
            this.cnt = cnt;
        }


        @Override
        public int compareTo(Pair o) {
            int cmp = this.cnt - o.cnt;
            if (cmp == 0) {
                return o.key.compareTo(this.key);
            }
            return cmp;
        }
    }

    public static void main(String[] args) {

        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        Solution692 solution692 = new Solution692();
        List<String> list = solution692.topKFrequent(words, 2);
        for (String it : list) {
            System.out.println(it);
        }

    }

}
