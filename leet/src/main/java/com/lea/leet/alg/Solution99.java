//package com.lea.leet.alg;
//
//import com.lea.leet.alg.base.TreeNode;
//
//public class Solution99 {
//
//    private TreeNode x;
//    private TreeNode y;
//    private TreeNode pre;
//
//    public void recoverTree(TreeNode root) {
//        inOrder(root);
//        if(x != null && y != null){
//            int tmp = x.val;
//            x.val = y.val;
//            y.val = tmp;
//        }
//    }
//
//    public void inOrder(TreeNode root){
//        if(root == null){
//            return ;
//        }
//
//        inOrder(root.left);
//        if(root.right != null){
//            if()
//        }
//
//        pre = root;
//        inOrder(root.right);
//    }
//
//}
