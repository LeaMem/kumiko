package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.LinkedList;

public class Solution114_For {

    public void flatten(TreeNode root) {

        LinkedList<TreeNode> stack = new LinkedList<>();

        //要用前序遍历的方式
        stack.push(root);

        TreeNode pre = new TreeNode(0);

        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();

            if (tmp != null) {
                //消费
                pre.right = tmp;
                pre.left = null;
                pre = tmp;

                TreeNode right = tmp.right;
                TreeNode left = tmp.left;
                stack.push(right);
                stack.push(left);

            }

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

        Solution114_For solution114_for = new Solution114_For();
        solution114_for.flatten(root);

    }

}
