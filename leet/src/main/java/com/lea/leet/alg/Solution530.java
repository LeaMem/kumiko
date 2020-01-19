package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution530 {

    public int getMinimumDifference(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        middleOrder(root, list);

        if (list.size() <= 1) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, Math.abs(list.get(i) - list.get(i - 1)));
        }

        return min;
    }

    public void middleOrder(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }

        middleOrder(root.left, list);
        list.add(root.val);
        middleOrder(root.right, list);
    }

}
