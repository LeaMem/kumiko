package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

public class Solution938 {

    public int rangeSumBST(TreeNode root, int L, int R) {

        int sum = 0;

        return sum(root, 0, L, R);
    }

    public int sum(TreeNode root, int sum, int L, int R) {

        if (root == null) {
            return 0;
        }

        if (root.val <= R && root.val >= L) {
            sum += root.val;
        }

        sum += sum(root.left, 0, L, R);
        sum += sum(root.right, 0, L, R);
        return sum;
    }

}
