package com.lea.leet.alg;


import com.lea.leet.alg.base.TreeNode;

public class Solution222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
