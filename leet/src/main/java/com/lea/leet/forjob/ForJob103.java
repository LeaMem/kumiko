package com.lea.leet.forjob;

import com.lea.leet.alg.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ForJob103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root == null){
            return Collections.emptyList();
        }

        List<List<Integer>> resultList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            if(level % 2 != 0){
                Collections.reverse(list);
            }
            level++;
            resultList.add(list);
        }
        return resultList;
    }

    public static void main(String[] args) {

    }

}
