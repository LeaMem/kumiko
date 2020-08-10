package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution655 {

    public List<List<String>> printTree(TreeNode root) {

        int height = getHeight(root);
        int size = (int) (Math.pow(2, height) - 1);

        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<String> tmpList = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                tmpList.add("");
            }
            list.add(tmpList);
        }

        dfs(list, 0, 0, size - 1, root);
        return list;
    }

    public void dfs(List<List<String>> list, int height, int l, int r, TreeNode root) {
        if (root == null) {
            return;
        }
        int index = (l + r) / 2;
        List<String> tmpList = list.get(height);
        tmpList.set(index, "" + root.val);
        height++;
        dfs(list, height, l, index, root.left);
        dfs(list, height, index + 1, r, root.right);
    }


    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

        Solution655 solution655 = new Solution655();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        List<List<String>> lists = solution655.printTree(root);
        for (List<String> list : lists) {
            String collect = String.join(",", list);
            System.out.println(collect);
        }

    }
}
