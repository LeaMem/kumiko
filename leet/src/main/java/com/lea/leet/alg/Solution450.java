package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

public class Solution450 {

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {

            //左右节点都不存在
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left != null) {
                TreeNode pre = predecessor(root.left);
                root.val = pre.val;
                root.left = deleteNode(root.left, root.val);
            } else {
                //如果有右节点，找下一个
                TreeNode next = successor(root.right);
                root.val = next.val;
                root.right = deleteNode(root.right, root.val);
            }

        }

        return root;
    }

    public TreeNode successor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public TreeNode predecessor(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

}
