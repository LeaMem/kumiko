package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/* https://leetcode-cn.com/problems/validate-binary-search-tree/solution/zhong-xu-bian-li-qing-song-na-xia-bi-xu-miao-dong-/ */
public class Solution98 {

    public boolean isValidBST(TreeNode root) {

        TreeNode tmp = root;
        Deque<TreeNode> stack = new LinkedList<>();

        long preVal = Long.MIN_VALUE;

        while (tmp != null || !stack.isEmpty()) {

            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }

            tmp = stack.pop();

            if(preVal >= tmp.val){
                return false;
            }

            preVal = tmp.val;
            tmp = tmp.right;

        }

        return true;
    }

}
