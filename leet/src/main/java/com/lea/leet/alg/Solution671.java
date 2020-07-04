package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.TreeSet;

public class Solution671 {

    private TreeSet<Integer> treeSet = new TreeSet<>();

    public int findSecondMinimumValue(TreeNode root) {

        traverse(root);

        if(treeSet.size() <= 1){
            return -1;
        }
        treeSet.pollFirst();
        return treeSet.pollFirst();
    }


    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        treeSet.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

}
