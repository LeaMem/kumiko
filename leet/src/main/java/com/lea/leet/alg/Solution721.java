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
                int root0 = find(parent, list.get(0));
                int rootI = find(parent, integer);
                if (root0 != rootI) {
                    parent[rootI] = root0;
                }
            }
        }


        Map<String, Set<String>> ansMap = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++){
            int root = parent[i];
            String name = accounts.get(root).get(0);
            for(int j = 1; j < accounts.get(j).size(); j++){
                String mail = accounts.get(j).get(j);
                Set<String> set = ansMap.getOrDefault(name, new TreeSet<>());
                set.add(mail);
                ansMap.put(name, set);
            }
        }

        List<List<String>> list = new ArrayList<>();
        for(String name : ansMap.keySet()){
            List<String> accountList = new ArrayList<>();
            Set<String> mailTreeSet = ansMap.get(name);
            accountList.add(name);
            accountList.addAll(mailTreeSet);
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

                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("Mary", "mary@mail.com")

        );

        Solution721 solution721 = new Solution721();
        solution721.accountsMerge(accounts);


    }
}
