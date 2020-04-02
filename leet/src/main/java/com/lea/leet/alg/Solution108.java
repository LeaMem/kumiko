package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.Arrays;

public class Solution108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        Arrays.sort(nums);
        return insert(nums, 0, nums.length - 1);
    }

    public TreeNode insert(int[] nums, int l, int r) {

        if (l <= r) {

            int mid = (l + r) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = insert(nums, l, mid - 1);
            root.right = insert(nums, mid + 1, r);
            return root;
        }

        return null;
    }

    public static void midOrder(TreeNode treeNode) {
        if (treeNode != null) {
            midOrder(treeNode.left);
            System.out.println(" " + treeNode.val + " ");
            midOrder(treeNode.right);
        }
    }

    public static void main(String[] args) {

        int[] nums = {-10, -3, 0, 5, 9};
        Solution108 solution108 = new Solution108();
        TreeNode root = solution108.sortedArrayToBST(nums);

        midOrder(root);
    }

}
