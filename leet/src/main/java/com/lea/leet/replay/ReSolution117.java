package com.lea.leet.replay;

import com.lea.leet.alg.Solution117.Node;

public class ReSolution117 {

	public Node connect(Node root) {
		dfs(root, null);
		return root;
	}

	public void dfs(Node root, Node next) {
		if (root == null) {
			return;
		}

		root.next = next;
		if (root.left != null && root.right != null) {
			dfs(root.right, getNextNode(next));
			dfs(root.left, root.right);
		} else if (root.left == null) {
			dfs(root.right, getNextNode(next));
		} else {
			dfs(root.left, getNextNode(next));
		}
	}

	public Node getNextNode(Node next) {
		while (next != null) {
			if (next.left != null) {
				return next.left;
			}
			if (next.right != null) {
				return next.right;
			}
			next = next.next;
		}
		return null;
	}

}
