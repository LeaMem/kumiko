package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

public class Solution114 {

    private TreeNode parent = new TreeNode(0);

    public void flatten(TreeNode root) {

        helper(root);
    }

    public void helper(TreeNode root) {

        if (root != null) {

            TreeNode left = root.left;
            TreeNode right = root.right;

            parent.right = root;
            parent.left = null;
            parent = root;

            helper(left);
            helper(right);

        }

    }



    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        root.left = two;
        two.left = three;
        two.right = four;
        root.right = five;
        five.right = six;

        Solution114 solution114 = new Solution114();
        solution114.flatten(root);

    }


}
