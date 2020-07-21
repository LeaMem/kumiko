package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;


public class Solution865 {


    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null){
            return null;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if(left == right){
            return root;
        }

        if(left > right){
            return subtreeWithAllDeepest(root.left);
        }

        return subtreeWithAllDeepest(root.right);
    }

    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return Math.max(left, right) + 1;
    }


}
