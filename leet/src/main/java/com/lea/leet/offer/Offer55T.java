package com.lea.leet.offer;

import com.lea.leet.alg.base.TreeNode;

public class Offer55T {

    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {

        if(root == null){
            return true;
        }

        if(!isBalanced(root.left)){
            return false;
        }

        if(Math.abs(getHeight(root.left) - getHeight(root.right)) > 1){
            return false;
        }

        return isBalanced(root.right);
    }

}
