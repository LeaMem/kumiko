package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 *      最快的是遍历的时候就维护最大次数
 */
public class Solution508 {

    public int[] findFrequentTreeSum(TreeNode root) {

        if(root == null){
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);

        TreeMap<Integer, List<Integer>> result = map
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, TreeMap::new, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

       return result
               .lastEntry()
               .getValue()
               .stream()
               .mapToInt(Integer::intValue)
               .toArray();

    }

    public int dfs(TreeNode root, Map<Integer, Integer> map) {

        if (root == null) {
            return 0;
        }

        int left = dfs(root.left, map);
        int right = dfs(root.right, map);

        int sum = root.val + left + right;
        Integer cnt = map.getOrDefault(sum, 0);
        cnt++;
        map.put(sum, cnt);
        return sum;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        Solution508 solution508 = new Solution508();
        int[] frequentTreeSum = solution508.findFrequentTreeSum(root);
        System.out.println(frequentTreeSum);
    }

}
