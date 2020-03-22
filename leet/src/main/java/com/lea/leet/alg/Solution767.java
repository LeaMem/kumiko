package com.lea.leet.alg;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *      2020.03.22
 *      看题解这里可以用贪心算法，我现在还不会
 */
public class Solution767 {

    public static void main(String[] args) {
        Solution767 solution767 = new Solution767();
        String res = solution767.reorganizeString("aabbc");
        System.out.println(res);
    }

    public String reorganizeString(String S) {

        PriorityQueue<CCnt> queue = toPriorityQueue(S);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            CCnt cCnt = queue.poll();
            if (cCnt.weight > (S.length() + 1) / 2) {
                return "";
            }
            if (i == 0 || builder.charAt(builder.length() - 1) != cCnt.ch) {
                builder.append(cCnt.ch);
                cCnt.weight--;
                if (cCnt.weight > 0) {
                    queue.add(cCnt);
                }
            } else {
                CCnt second = queue.poll();
                builder.append(second.ch);
                second.weight--;
                if (second.weight > 0) {
                    queue.add(second);
                }
                queue.add(cCnt);
            }
        }


        return builder.toString();
    }

    public PriorityQueue<CCnt> toPriorityQueue(String S) {

        Map<Character, Integer> map = new HashMap<>();

        for (Character ch : S.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        PriorityQueue<CCnt> queue = new PriorityQueue<>(new Comparator<CCnt>() {
            @Override
            public int compare(CCnt o1, CCnt o2) {
                return o2.weight - o1.weight;
            }
        });
        for (Character ch : map.keySet()) {
            CCnt cnt = new CCnt();
            cnt.ch = ch;
            cnt.weight = map.get(ch);
            queue.add(cnt);
        }
        return queue;
    }

    public static class CCnt {
        public Character ch;
        public Integer weight;
    }


}
