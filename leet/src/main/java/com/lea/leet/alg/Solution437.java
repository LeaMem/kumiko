package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

public class Solution437 {

//    int total = 0;
//
//    public int pathSum(TreeNode root, int sum) {
//
//        if (root == null) {
//            return 0;
//        }
//
//        sumIt(root, sum, 0);
//
//        pathSum(root.left, sum);
//        pathSum(root.right, sum);
//
//        return total;
//    }
//
//    public void sumIt(TreeNode root, int sum, int preSum) {
//
//        if (root == null) {
//            return;
//        }
//        if (preSum + root.val == sum) {
//            total++;
//        }
//        sumIt(root.left, sum, preSum + root.val);
//        sumIt(root.right, sum, preSum + root.val);
//    }


    public int pathSum(TreeNode root, int sum) {
        return pathSumHelper(root, sum, new int[1000], 0);
    }

    public int pathSumHelper(TreeNode root, int sum, int[] path/*保存路径*/, int p/*指向路径终点*/){
        if(root == null) return 0;
        path[p] = root.val;
        int curSum = root.val;
        int n = curSum==sum? 1:0;
        for(int i = p-1; i>=0; i--){
            curSum += path[i];
            if(curSum == sum) n++;
        }

        int n1 = pathSumHelper(root.left, sum, path, p+1);
        int n2 = pathSumHelper(root.right, sum, path, p+1);
        return n+n1+n2;
    }


}
