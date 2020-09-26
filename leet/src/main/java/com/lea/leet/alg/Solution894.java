package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution894 {

    public List<TreeNode> allPossibleFBT(int N) {
        if (N % 2 == 0) {
            return new ArrayList<>();
        }
        if (N == 1) {
            TreeNode treeNode = new TreeNode(0);
            return Collections.singletonList(treeNode);
        }
        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i <= N - 1; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - 1 - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }

}
