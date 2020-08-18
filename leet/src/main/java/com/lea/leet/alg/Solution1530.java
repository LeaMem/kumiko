package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1530 {

    List<Integer> list = new ArrayList<>();

    public int countPairs(TreeNode root, int distance) {
        return 0;
    }

    public void dfs(TreeNode root, int x){
        if(root == null){
            return ;
        }
        if(root.left == null && root.right == null){
            list.add(x);
        }
        dfs(root.left, 2 * x + 1);
        dfs(root.right, 2 * x + 2);
    }

}
