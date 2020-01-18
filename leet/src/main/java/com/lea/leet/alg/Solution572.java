package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

public class Solution572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (s == null) {
            return false;
        }

        return compare(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean compare(TreeNode s, TreeNode t) {

        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }

        if (s.val != t.val) {
            return false;
        }

        return compare(s.left, t.left) && compare(s.right, t.right);
    }

}
