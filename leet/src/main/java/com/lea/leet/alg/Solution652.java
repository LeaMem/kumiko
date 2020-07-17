package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution652 {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        List<TreeNode> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        dfs(root, map, list);

        return list;
    }

    public String dfs(TreeNode root, Map<String, Integer> map, List<TreeNode> list) {

        if (root == null) {
            return "null";
        }

        String left = dfs(root.left, map, list);
        String right = dfs(root.right, map, list);
        String serialize = String.format("%d,%s,%s", root.val, left, right);
        Integer cnt = map.getOrDefault(serialize, 0);
        cnt++;
        if(cnt == 2){
            list.add(root);
        }

        map.put(serialize, cnt);

        return serialize;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        left.left = new TreeNode(4);
        right.left = new TreeNode(2);
        right.left.left = new TreeNode(4);
        right.right = new TreeNode(4);
        root.left = left;
        root.right = right;


        Solution652 solution652 = new Solution652();
        List<TreeNode> list = solution652.findDuplicateSubtrees(root);
        System.out.println(list.size());

    }

}
