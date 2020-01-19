package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

public class Solution617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode tmp = new TreeNode(0);
        tmp.left = new TreeNode(0);
        merge(tmp, tmp.left, t1, t2);
        return tmp.left;
    }

    public void merge(TreeNode parent, TreeNode node, TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            //清空
            if (parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }

        } else {

            node.left = new TreeNode(0);
            node.right = new TreeNode(0);

            if (t1 == null) {
                //t2有值
                node.val = t2.val;
                merge(node, node.left, null, t2.left);
                merge(node, node.right, null, t2.right);
            } else if (t2 == null) {
                //t1有值
                node.val = t1.val;
                merge(node, node.left, t1.left, null);
                merge(node, node.right, t1.right, null);
            } else {
                node.val = t1.val + t2.val;
                merge(node, node.left, t1.left, t2.left);
                merge(node, node.right, t1.right, t2.right);
            }

        }

    }

    public static void setStr(String str) {
        str = "ding";
    }

    public static void remove(TreeNode node) {
        node = new TreeNode(6);
    }

    public static void main(String[] args) {

    }

}
