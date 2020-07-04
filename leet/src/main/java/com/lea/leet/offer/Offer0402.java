package com.lea.leet.offer;

import com.lea.leet.alg.base.TreeNode;

public class Offer0402 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }


    public TreeNode solve(int[] nums, int left, int right){

        if(left > right){
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = solve(nums, left, mid - 1);
        root.right = solve(nums, mid + 1, right);
        return root;
    }

}
