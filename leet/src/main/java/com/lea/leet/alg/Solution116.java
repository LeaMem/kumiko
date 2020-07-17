package com.lea.leet.alg;


public class Solution116 {

    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }

    //每个 node 左子树的 next , 就是 node 的右子树
    //每个 node 右子树的 next, 就是 node next 的 左子树
    public void dfs(Node root, Node next){

        if(root == null){
            return;
        }

        root.next = next;
        dfs(root.left, root.right);

        if(next != null){
            next = next.left;
        }
        dfs(root.right, next);
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

}
