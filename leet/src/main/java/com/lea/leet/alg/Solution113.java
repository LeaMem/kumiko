package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.*;

public class Solution113 {


    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> resultList = new LinkedList<>();

        if (root == null) {
            return resultList;
        }

        //队列
        LinkedList<TreeNode> queue = new LinkedList<>();

        LinkedList<List<Integer>> routeQueue = new LinkedList<>();

        queue.add(root);
        routeQueue.add(Collections.singletonList(root.val));

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            List<Integer> route = routeQueue.poll();

            if (node.left == null && node.right == null) {
                Integer ans = route
                        .stream()
                        .reduce(0, Integer::sum);
                if (ans == sum) {
                    resultList.add(route);
                }
            }

            if (node.left != null) {
                queue.add(node.left);
                ArrayList<Integer> leftRoute = new ArrayList<>(route);
                leftRoute.add(node.left.val);
                routeQueue.add(leftRoute);
            }

            if (node.right != null) {
                queue.add(node.right);
                ArrayList<Integer> rightRoute = new ArrayList<>(route);
                rightRoute.add(node.right.val);
                routeQueue.add(rightRoute);
            }

        }

        return resultList;
    }


}
