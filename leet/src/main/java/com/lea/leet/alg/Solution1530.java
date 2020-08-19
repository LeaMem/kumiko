package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1530 {

    int dis;
    int cnt;
    public int countPairs(TreeNode root, int distance) {
        this.dis = distance;
        this.cnt = 0;
        dfs(root);
        return this.cnt;
    }

    public List<Integer> dfs(TreeNode root){

        if(root == null){
            return new ArrayList<>();
        }

        if(root.left == null && root.right == null){
            return Collections.singletonList(1);
        }

        List<Integer> left = dfs(root.left);
        List<Integer> right = dfs(root.right);

        for(Integer l : left){
            for (Integer r : right){
                if(l + r <= dis){
                    cnt++;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for(Integer it : left){
            int tmp = it + 1;
            if(tmp <= dis){
                list.add(tmp);
            }
        }

        for(Integer it : right){
            int tmp = it + 1;
            if(tmp <= dis){
                list.add(tmp);
            }
        }

        return list;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        Solution1530 solution1530 = new Solution1530();
        int ans = solution1530.countPairs(root, 3);
        System.out.println(ans);
    }

}
