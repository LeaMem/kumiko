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

        dfs(root, 0, size / 2, list);
        return list;
    }

    public void dfs(TreeNode root, int height, int index, List<List<String>> list) {
        if (root == null) {
            return;
        }
        List<String> tmpList = list.get(height);
        tmpList.set(index, "" + root.val);
        height++;
        int size = (int) Math.pow(2, height) - 1;
        int left = (index - 1) / 2;
        int right = size - left;
        dfs(root.left, height, left, list);
        dfs(root.right, height, right, list);
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        List<List<String>> lists = solution655.printTree(root);
        for (List<String> list : lists) {
            String collect = String.join(",", list);
            System.out.println(collect);
        }

    }
}
