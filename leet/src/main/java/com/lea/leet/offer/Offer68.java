package com.lea.leet.offer;

import com.lea.leet.alg.base.TreeNode;

public class Offer68 {

    TreeNode root;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        find(root, p, q);

        return this.root;
    }

    public void find(TreeNode root, TreeNode p, TreeNode q) {

        this.root = root;

        if (contains(root, p) && contains(root, q)) {
            return;
        }

        find(root.left, p, q);
        find(root.right, p, q);

    }

    public boolean contains(TreeNode root, TreeNode p) {

        if (root == null) {
            return false;
        }

        return root == p || contains(root.left, p) || contains(root.right, p);
    }


    public static void main(String[] args) {

        System.out.println(0.1 / 230);

        double it = 1;

        for (int i = 0; i < 230; i++) {
            it *= 1.001;
        }

        System.out.println(it);

    }
}
