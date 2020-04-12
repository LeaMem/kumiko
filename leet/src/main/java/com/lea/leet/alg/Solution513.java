package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.LinkedList;

public class Solution513 {

    public int findBottomLeftValue(TreeNode root) {

            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            int last = Integer.MIN_VALUE;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {

                    TreeNode tmp = queue.poll();

                    if(i == 0){
                        last = tmp.val;
                    }

                    if(tmp.left != null){
                        queue.add(tmp.left);
                    }

                    if(tmp.right != null){
                        queue.add(tmp.right);
                    }
                }
            }

            return last;
    }

}
