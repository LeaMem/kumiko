package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

public class Solution129 {

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        solve(root, 0);
        return sum;
    }

    public void solve(TreeNode root, int val) {

        if (root == null) {
            return;
        }

        val = 10 * val + root.val;
        if (root.left == null && root.right == null) {
            sum += val;
        }

        solve(root.left, val);
        solve(root.right, val);
    }

}
