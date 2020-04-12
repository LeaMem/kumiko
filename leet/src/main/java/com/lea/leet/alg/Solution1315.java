package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

public class Solution1315 {

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumIt(root, root.left) + sumIt(root, root.right);
    }

    public int sumIt(TreeNode root, TreeNode parent) {

        if (parent == null || root == null) {
            return 0;
        }

        int sum = 0;

        //当前节点是 parent

        if (root.val % 2 == 0) {

            //parent左节点的值
            if (parent.left != null) {
                sum += parent.left.val;
            }

            //parent右节点的值
            if (parent.right != null) {
                sum += parent.right.val;
            }

        }

        return sum + sumIt(parent, parent.left) + sumIt(parent, parent.right);

    }

}
