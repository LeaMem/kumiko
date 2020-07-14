package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

public class Solution124 {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return ans;
    }

    public int postOrder(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int maxLeft = postOrder(root.left);
        int maxRight = postOrder(root.right);
        int sum = root.val + maxLeft + maxRight;
        ans = Math.max(sum, ans);
        int oneSide = Math.max(maxLeft, maxRight) + root.val;
        return Math.max(oneSide, 0);
    }

    public static void main(String[] args) {



    }


}
