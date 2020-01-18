package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution606 {

    public String tree2str(TreeNode t) {

        StringBuilder builder = new StringBuilder();

        if (t == null) {
            return builder.toString();
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(t);

        while (!stack.isEmpty()) {

            TreeNode tmp = stack.peek();

            //访问过
            if (visited.contains(tmp)) {
                stack.pop();
                builder.append(")");
            } else {
                //如果之前没有访问过
                visited.add(tmp);
                builder.append("(").append(tmp.val);

                if (tmp.left == null && t.right != null) {
                    builder.append("()");
                }
                if (t.right != null) {
                    stack.push(t.right);
                }
                if (t.left != null) {
                    stack.push(t.left);
                }

            }

        }

        String s = builder.toString();
        return s.substring(1, s.length() - 1);
    }

    public String preTraverse(TreeNode root) {

        StringBuilder builder = new StringBuilder();

        if (root != null) {

            builder.append(root.val);

            if (root.left != null) {
                builder.append("(").append(preTraverse(root.left)).append(")");
            }

            if (root.right != null) {
                if (root.left == null) {
                    builder.append("()");
                }
                builder.append("(").append(preTraverse(root.right)).append(")");
            }

        }

        return builder.toString();
    }

}
