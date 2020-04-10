package com.lea.leet.alg;

import java.util.*;

public class Solution811 {

    Map<String, Integer> map = new HashMap<>();

    public List<String> subdomainVisits(String[] cpdomains) {

        List<String> result = new ArrayList<>();

        for (String str : cpdomains) {
            analyze(str);
        }

        for (String key : map.keySet()) {
            result.add(String.format("%d %s", map.get(key), key));
        }

        return result;
    }

    public void analyze(String str) {

        String[] strings = str.split("\\s+");

        Integer cnt = Integer.valueOf(strings[0]);

        List<String> list = new LinkedList<>();

        String[] domains = strings[1].split("\\.");

        for (int i = domains.length - 1; i >= 0; i--) {

            list.add(0, domains[i]);

            String key = String.join(".", list);

            if (map.containsKey(key)) {
                map.put(key, map.get(key) + cnt);
            } else {
                map.put(key, cnt);
            }
        }

    }

    public static void main(String[] args) {

        String str = "9001 discuss.leetcode.com";

        List<String> list = new Solution811().subdomainVisits(new String[]{str});

        for (String it : list) {
            System.out.println(list);
        }

    }

}
