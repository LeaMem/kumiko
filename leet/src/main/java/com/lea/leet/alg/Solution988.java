package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.TreeSet;

public class Solution988 {

    TreeSet<String> treeSet = new TreeSet<>();

    public String smallestFromLeaf(TreeNode root) {

        if (root == null) {
            return "";
        }

        dfs(root, "");
        return treeSet.first();
    }

    public void dfs(TreeNode root, String last) {
        if (root == null) {
            return;
        }

        last = (char) (root.val + 'a') + last;
        if (root.left == null && root.right == null) {
            treeSet.add(last);
        }

        dfs(root.left, last);
        dfs(root.right, last);
    }
}
