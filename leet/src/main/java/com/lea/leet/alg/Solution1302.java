package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 哇擦，有个人非常厉害，因为并不需要知道有几层
 * 只要求得最后一层的 sum 就可以了
 */
public class Solution1302 {

    public int deepestLeavesSum(TreeNode root) {

        Deque<TreeNode> queue = new LinkedList<>();
        int sum = 0;
        queue.add(root);

        while (root != null && !queue.isEmpty()) {

            int size = queue.size();
            int tmpSum = 0;
            for (int i = 0; i < size; i++) {

                TreeNode tmp = queue.poll();
                tmpSum += tmp.val;
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }

                sum = tmpSum;

            }
        }

        return sum;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        root.left = second;
        root.right = third;

        int i = new Solution1302().deepestLeavesSum(root);
        System.out.println(i);
    }


}
