package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution230 {

    public int kthSmallest(TreeNode root, int k) {

        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode tmp = stack.pop();

            k--;

            if (k == 0) {
                return tmp.val;
            }

            root = tmp.right;

        }

        return 0;
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(2);

        t1.left = t2;
        t1.right = t3;
        t2.right = t4;

        int res = new Solution230().kthSmallest(t1, 2);

        System.out.println(res);

    }

}
