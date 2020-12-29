package com.lea.leet.replay;

import com.lea.leet.alg.base.TreeNode;

public class ReSolution124 {

	public int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		preOrderTraverse(root);
		return max;
	}

	public int preOrderTraverse(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = preOrderTraverse(root.left);
		int right = preOrderTraverse(root.right);
		int sum = root.val + left + right;
		max = Math.max(sum, max);

		//dp最大值
		//一条边的最大值
		int oneSide = Math.max(left, right) + root.val;
		return Math.max(oneSide, 0);
	}

}
