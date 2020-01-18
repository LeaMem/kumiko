package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> ans1 = preTraverse(root1);
        List<Integer> ans2 = preTraverse(root2);

        if (ans1.isEmpty() && ans2.isEmpty()) {
            return true;
        }

        if (!ans1.isEmpty() && !ans2.isEmpty()) {
            if (ans1.size() != ans2.size()) {
                return false;
            }
            boolean flag = true;
            for (int i = 0; i < ans1.size(); i++) {
                if (ans1.get(i) != ans2.get(i)) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }

        return false;
    }

    public List<Integer> preTraverse(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }

            if(tmp.left == null && tmp.right == null){
                res.add(tmp.val);
            }
        }
        return res;
    }
}
