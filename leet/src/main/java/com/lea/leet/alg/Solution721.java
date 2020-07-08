package com.lea.leet.alg;

import java.util.*;

public class Solution721 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            List<String> mailList = accounts.get(i);

            for (int j = 1; j < mailList.size(); j++) {
                String mail = mailList.get(j);
                List<Integer> list = map.getOrDefault(mail, new ArrayList<>());
                list.add(i);
                map.put(mail, list);
            }

        }

        int[] parent = new int[accounts.size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        //并查集合并
        for (String mail : map.keySet()) {
            List<Integer> list = map.get(mail);
            for (Integer integer : list) {
                int rootI = find(parent, integer);
                int root0 = find(parent, list.get(0));
                if (root0 != rootI) {
                    parent[rootI] = root0;
                }
            }
        }

        Map<Integer, Set<String>> ansMap = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {

            //这里是精华
            int root = find(parent, i);
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                Set<String> set = ansMap.getOrDefault(root, new TreeSet<>());
                set.add(mail);
                ansMap.put(root, set);
            }

        }

        List<List<String>> list = new ArrayList<>();
        for (Integer root : ansMap.keySet()) {
            List<String> accountList = new ArrayList<>();
            String name = accounts.get(root).get(0);
            accountList.add(name);
            accountList.addAll(ansMap.get(root));
            list.add(accountList);
        }


        return list;
    }

    public int find(int[] parent, int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public static void main(String[] args) {

        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("David", "David0@m.co", "David1@m.co"),
                Arrays.asList("David", "David3@m.co", "David4@m.co"),
                Arrays.asList("David", "David4@m.co", "David5@m.co"),
                Arrays.asList("David", "David2@m.co", "David3@m.co"),
                Arrays.asList("David", "David1@m.co", "David2@m.co")
        );

        Solution721 solution721 = new Solution721();
        solution721.accountsMerge(accounts);


    }
}
