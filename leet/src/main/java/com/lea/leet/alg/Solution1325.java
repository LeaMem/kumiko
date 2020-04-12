package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

public class Solution1325 {

    public TreeNode removeLeafNodes(TreeNode root, int target) {

        if (root == null || (root.left == null && root.right == null && root.val == target)) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        //删除好了还要判断下
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;
    }

}
