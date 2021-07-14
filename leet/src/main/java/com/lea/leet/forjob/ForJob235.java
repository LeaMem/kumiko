package com.lea.leet.forjob;

import com.lea.leet.alg.base.TreeNode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ForJob235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return rootOf(root, q, p);
        }
        return rootOf(root, p, q);
    }


    public TreeNode rootOf(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val >= p.val && root.val <= q.val) {
            return root;
        }
        if (root.val <= p.val) {
            return rootOf(root.right, p, q);
        }
        return rootOf(root.left, p, q);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
    }

}
