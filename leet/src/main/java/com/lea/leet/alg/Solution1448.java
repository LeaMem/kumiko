package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

public class Solution1448 {

    private int cnt = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return cnt;
    }

    public void dfs(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (max <= root.val) {
            cnt++;
        }
        max = Math.max(max, root.val);
        dfs(root.left, max);
        dfs(root.right, max);
    }

}
