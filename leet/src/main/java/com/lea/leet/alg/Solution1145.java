package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

public class Solution1145 {

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {

        //node
        TreeNode node = find(root, x);

        int left = getCnt(node.left);
        int right = getCnt(node.right);

        return left > n / 2 || right > n / 2 || (left + right + 1) <= n / 2;
    }

    public TreeNode find(TreeNode root, int x){

        if(root == null){
            return null;
        }

        if(root.val == x){
            return root;
        }

        TreeNode left = find(root.left, x);

        if(left != null){
            return left;
        }

        return find(root.right, x);
    }

    public int getCnt(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getCnt(root.left);
        int right = getCnt(root.right);
        return left + right + 1;
    }

}
