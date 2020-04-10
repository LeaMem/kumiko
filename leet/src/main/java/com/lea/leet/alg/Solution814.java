package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

public class Solution814 {

    public TreeNode pruneTree(TreeNode root) {

        if (root == null || !containsOne(root)) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root;
    }

    public boolean containsOne(TreeNode root) {
        if (root == null) {
            return false;
        }
        return root.val == 1 || containsOne(root.left) || containsOne(root.right);
    }

}
