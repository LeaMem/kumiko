package com.lea.leet.offer;

import com.lea.leet.alg.base.TreeNode;

public class Offer55F {

    public int maxDepth(TreeNode root) {
        return getHeight(root);
    }

    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

}
