package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.LinkedList;

public class Solution1022 {

    public int sumRootToLeaf(TreeNode root) {

        if (root == null) {
            return 0;
        }

        LinkedList<Kitty> queue = new LinkedList<>();
        queue.add(new Kitty(root));

        int sum = 0;
        while (!queue.isEmpty()) {

            Kitty pop = queue.pop();

            if (pop.node.left != null) {
                queue.add(new Kitty(pop.node.left, pop.str));
            }

            if (pop.node.right != null) {
                queue.add(new Kitty(pop.node.right, pop.str));
            }

            if (pop.node.left == null && pop.node.right == null) {
                sum += Integer.parseInt(pop.str, 2);
            }
        }

        return sum;

    }

    public static class Kitty {
        public TreeNode node;
        public String str;

        public Kitty(TreeNode node) {
            this.node = node;
            this.str = String.valueOf(node.val);
        }

        public Kitty(TreeNode node, String str) {
            this.node = node;
            this.str = str + node.val;
        }
    }

}
