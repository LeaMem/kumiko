package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution95_traverseCreateBST {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        return getAns(1, n);
    }

    public List<TreeNode> getAns(int l, int r) {

        List<TreeNode> ans = new ArrayList<>();

        if (l > r) {
            ans.add(null);
            return ans;
        }

        if (l == r) {
            TreeNode treeNode = new TreeNode(l);
            ans.add(treeNode);
            return ans;
        }

        //从l-r中选取一个当作root
        for (int i = l; i <= r; i++) {

            List<TreeNode> leftTrees = getAns(l, i - 1);
            List<TreeNode> rightTrees = getAns(i + 1, r);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    ans.add(root);
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {

        Solution95_traverseCreateBST solution95TraverseCreateBST = new Solution95_traverseCreateBST();
        List<TreeNode> treeNodes = solution95TraverseCreateBST.generateTrees(3);
        System.out.println(treeNodes.size());

    }

}
