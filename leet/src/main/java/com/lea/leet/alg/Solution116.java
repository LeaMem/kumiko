package com.lea.leet.alg;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution116 {

	public Node connect(Node root) {
		dfs(root, null);
		return root;
	}

	//每个 node 左子树的 next , 就是 node 的右子树
	//每个 node 右子树的 next, 就是 node next 的 左子树
	public void dfs(Node root, Node next) {

		if (root == null) {
			return;
		}

		root.next = next;
		dfs(root.left, root.right);

		if (next != null) {
			next = next.left;
		}
		dfs(root.right, next);
	}

	public static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

	public static void main(String[] args) {

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;

		Solution116 solution116 = new Solution116();
//		Node node = solution116.connect(node1);
//		System.out.println(node);

		solution116.preOrder(node1, new ArrayList<>());
	}


	public void preOrder(Node node, List<Integer> routeList){

		if(node == null){
			return ;
		}

		routeList.add(node.val);

		if(node.left == null && node.right == null){
			String collect = routeList.stream().map(String::valueOf).collect(Collectors.joining(","));
			System.out.println(collect);
		}

		preOrder(node.left, routeList);
		preOrder(node.right, routeList);
		routeList.remove(routeList.size() - 1);
	}

}
