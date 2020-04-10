package com.lea.leet.alg;

import java.util.*;


/**
 *      看题目，别人用数组维护了size， 然后左右遍历就可以了
 *      我写的这个太复杂了
 */
public class Solution1370 {

    public String sortString(String s) {

        TreeMap<Character, Integer> map = new TreeMap<>();

        for (Character ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        StringBuilder builder = new StringBuilder();

        //找到最大的
        while (!map.isEmpty()) {

            //从小打到
            builder.append(getStr(map));
            builder.append(getStr(map).reverse());
        }

        return builder.toString();
    }

    public StringBuilder getStr(Map<Character, Integer> map) {

        StringBuilder builder = new StringBuilder();

        for (Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Character, Integer> next = it.next();
            int size = next.getValue();
            builder.append(next.getKey());
            size--;
            if (size > 0) {
                next.setValue(size);
            } else {
                it.remove();
            }
        }

        return builder;
    }

    public static void main(String[] args) {

        String str = "rat";
        String s = new Solution1370().sortString(str);
        System.out.println(s);

    }

}
