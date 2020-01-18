package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution637 {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.pop();
                sum += tmp.val;
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            list.add(1.0 * sum / size);
        }
        return list;
    }

//    public static void main(String[] args) {
//        new Solution637().averageOfLevels()
//    }

}
