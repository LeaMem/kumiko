package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;


/**
 *      这里参考的别人的思路实现的
 *      采用自底向上的方式
 */
public class Solution979 {

    public int distributeCoins(TreeNode root) {
        MoveStatus moveStatus = new MoveStatus();
        dfs(root, moveStatus);
        return moveStatus.moveStatement;
    }

    public int dfs(TreeNode root, MoveStatus moveStatus){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left, moveStatus);
        int right = dfs(root.right, moveStatus);
        moveStatus.moveStatement += Math.abs(left) + Math.abs(right);

        return left + right + root.val - 1;
    }



//    int step = 0;
//
//    public int distributeCoins(TreeNode root) {
//        solve(root);
//        return step;
//    }
//
//    public int solve(TreeNode root){
//
//        if(root == null){
//            return 0;
//        }
//
//        int left = solve(root.left);
//        int right = solve(root.right);
//
//        if(left != 0){
//            step += Math.abs(left);
//        }
//
//        if(right != 0){
//            step += Math.abs(right);
//        }
//
//        return left + right + root.val - 1;
//    }


    public static class MoveStatus{

        public int moveStatement;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        Solution979 solution979 = new Solution979();
        int result = solution979.distributeCoins(root);
        System.out.println(result);
    }

}
