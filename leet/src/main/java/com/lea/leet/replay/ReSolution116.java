package com.lea.leet.replay;


import com.lea.leet.alg.Solution116.Node;

public class ReSolution116 {

	public Node connect(Node root) {
		dfs(root);
		return root;
	}

	public void dfs(Node root) {
		if (root == null) {
			return;
		}
		Node left = root.left;
		Node right = root.right;
		while (left != null) {
			left.next = right;
			left = left.right;
			right = right.left;
		}
		dfs(root.left);
		dfs(root.right);
	}

}
