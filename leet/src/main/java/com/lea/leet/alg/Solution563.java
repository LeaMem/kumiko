package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

public class Solution563 {

    public int findTilt(TreeNode root) {
        return calc(root);
    }

    private int calc(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int now = 0;
        if (root.left != null && root.right != null) {
            now = Math.abs(root.left.val - root.right.val);
        } else if (root.left != null && root.right == null) {
            now = Math.abs(root.left.val);
        } else if (root.left == null && root.right != null) {
            now = Math.abs(root.right.val);
        }

        return now + calc(root.left) + calc(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        root.left = second;
        root.right = third;
        int tilt = new Solution563().findTilt(root);
        System.out.println(tilt);
    }
}
