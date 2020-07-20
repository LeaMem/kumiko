package com.lea.leet.offer;

import com.lea.leet.alg.base.TreeNode;

public class Offer0408 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //left, right都不为空，就是当前节点
        if(left != null && right != null){
            return root;
        }

        //如果left为空，就是说在右边
        if(left == null){
            return right;
        }
        return left;
    }

    public boolean hasChild(TreeNode root, TreeNode p) {

        if (root == null) {
            return false;
        }

        if (root == p) {
            return true;
        }

        boolean leftAns = hasChild(root.left, p);

        if (leftAns) {
            return true;
        }

        return hasChild(root.right, p);
    }

}
