package com.lea.leet.replay;

import com.lea.leet.alg.base.TreeNode;

public class Resolution105 {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return create(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	public TreeNode create(int[] preorder, int pS, int pE, int[] inorder, int iS, int iE) {

		if (pS > pE) {
			return null;
		}

		//找到根节点
		TreeNode root = new TreeNode(preorder[pS]);

		int idx = 0;
		for (int i = iS; i < iE + 1; i++) {
			if (inorder[i] == preorder[pS]) {
				//找到root
				idx = i;
				break;
			}
		}

		int len = idx - iS;

		root.left = create(preorder, pS + 1, pS + len, inorder, iS, iS + len);
		root.right = create(preorder, pS + len + 1, pE, inorder, iS + len + 1, iE);
		return root;
	}

	public static void main(String[] args) {

		Resolution105 resolution105 = new Resolution105();
		TreeNode treeNode = resolution105.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
		System.out.println(treeNode);
	}

}
