package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.LinkedList;

public class Solution563 {

    public int findTilt(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // 这里写后序遍历
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        int sum = 0;
        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }

            sum += calc(node);
        }
        return sum;
    }

    /**
     * 计算每个节点
     *
     * @param root
     * @return
     */
    private int calc(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        return Math.abs(left - right);
    }

    /**
     * 求左子树右子树所有的和
     *
     * @param root
     * @return
     */
    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val;
        sum += traverse(root.left);
        sum += traverse(root.right);
        return sum;
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
