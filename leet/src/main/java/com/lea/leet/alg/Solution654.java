package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

/**
 *      感觉这个递归很神奇，我之前没写出来
 */
public class Solution654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return create(nums, 0, nums.length - 1);
    }

    public TreeNode create(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int index = maxIndex(nums, l, r);

        TreeNode root = new TreeNode(nums[index]);

        root.left = create(nums, l, index - 1);
        root.right = create(nums, index + 1, r);

        return root;
    }

    private int maxIndex(int[] nums, int s, int e) {
        int index = s;
        for (int i = s; i <= e; i++) {
            if (nums[index] < nums[i]) {
                index = i;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};

        Solution654 solution654 = new Solution654();
        TreeNode node = solution654.constructMaximumBinaryTree(nums);
        System.out.println(node.val);
    }

}
