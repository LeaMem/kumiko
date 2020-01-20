package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

public class Solution700 {

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        TreeNode tmp = root;
        while (tmp != null) {
            if (tmp.val == val) {
                return tmp;
            } else if (tmp.val > val) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }

        return null;
    }


}
