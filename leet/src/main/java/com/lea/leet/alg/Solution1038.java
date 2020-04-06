package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

public class Solution1038 {

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {

        if (root != null) {
            bstToGst(root.right);

            sum += root.val;
            root.val = sum;

            bstToGst(root.left);
        }

        return root;
    }

}
