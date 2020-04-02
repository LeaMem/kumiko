package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution113_DFS {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> resultList = new ArrayList<>();

        if (root == null) {
            return resultList;
        }

        helper(root, sum, resultList, new ArrayList<>());

        return resultList;
    }

    public void helper(TreeNode root, int sum, List<List<Integer>> resultList, List<Integer> routeList) {

        if (root == null) {
            return;
        }

        routeList.add(root.val);

        //如果是叶子节点
        if (root.left == null && root.right == null && root.val - sum == 0) {
            ArrayList<Integer> tmp = new ArrayList<>(routeList);
            resultList.add(tmp);
        }

        helper(root.left, sum - root.val, resultList, routeList);
        helper(root.right, sum - root.val, resultList, routeList);

        //清空下路径
        routeList.remove(routeList.size() - 1);
    }

}
