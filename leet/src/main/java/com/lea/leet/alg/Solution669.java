package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

/**
 * 我好菜，递归都写不出来
 */
public class Solution669 {

    public TreeNode trimBST(TreeNode root, int L, int R) {

        if (root == null) {
            return null;
        }

        if (root.val < L) {
            return trimBST(root.right, L, R);
        }

        if (root.val > R) {
            return trimBST(root.left, L, R);
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

}
