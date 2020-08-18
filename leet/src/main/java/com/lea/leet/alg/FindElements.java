package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindElements {

    Set<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        dfs(root, 0);
    }

    private void dfs(TreeNode root, int x){
        if(root == null){
            return ;
        }
        set.add(x);
        dfs(root.left, 2 * x + 1);
        dfs(root.right, 2 * x + 2);
    }

    public boolean find(int target) {
        return set.contains(target);
    }

}
