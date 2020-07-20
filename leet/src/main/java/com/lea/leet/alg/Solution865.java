package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution865 {

    Integer max = 0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        Map<TreeNode, Integer> map = new HashMap<>();
        dfs(map, root, -1);

    }


    public Integer dfs(Map<TreeNode, Integer> map, TreeNode root, Integer depth){
        if(root == null){
            return 0;
        }
        depth++;
        map.put(root, depth);
        Integer left = dfs(map, root.left, depth);
        Integer right = dfs(map, root.right, depth);

        int tmp = Math.max(left, right);
        max = Math.max(tmp, max);
        return tmp;
    }

    public TreeNode ans(Map<TreeNode, Integer> map, TreeNode root){

        if(root == null){
            return null;
        }

        if(max.equals(map.get(root))){
            return root;
        }

        //左右是否有最大的深度解点
        TreeNode left = ans(map, root.left);
        TreeNode right = ans(map, root.right);
        if(left != null && right != null){
            return root;
        }

        if(left != null){

        }

    }

}
