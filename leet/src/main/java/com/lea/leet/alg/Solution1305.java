package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution1305 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> firstList = midOrder(root1);
        List<Integer> secondList = midOrder(root2);

        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstList.size() && j < secondList.size()) {
            if (firstList.get(i) < secondList.get(j)) {
                result.add(firstList.get(i));
                i++;
            } else {
                result.add(secondList.get(j));
                j++;
            }
        }

        while (i < firstList.size()) {
            result.add(firstList.get(i));
            i++;
        }

        while (j < secondList.size()) {
            result.add(secondList.get(j));
            j++;
        }

        return result;
    }

    public List<Integer> midOrder(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode tmp = stack.pop();
            list.add(tmp.val);
            root = tmp.right;
        }

        return list;
    }

}
