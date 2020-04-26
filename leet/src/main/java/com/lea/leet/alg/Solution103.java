package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.*;

public class Solution103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> resultList = new ArrayList<>();

        while(!queue.isEmpty()){
            int size = queue.size();

            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < size; i++){

                TreeNode tmp = queue.poll();
                list.add(tmp.val);

                if(tmp.left != null){
                    queue.add(tmp.left);
                }

                if(tmp.right != null){
                    queue.add(tmp.right);
                }

            }

            if(resultList.size() % 2 != 0){
                Collections.reverse(list);
            }

            resultList.add(list);
        }

        return resultList;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        List<List<Integer>> lists = new Solution103().zigzagLevelOrder(root);

        System.out.println(lists.size());


    }

}
