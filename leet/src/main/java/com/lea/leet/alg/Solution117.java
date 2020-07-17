package com.lea.leet.alg;

import java.util.LinkedList;

public class Solution117 {

//    public Node connect(Node root) {
//
//        if(root == null){
//            return null;
//        }
//
//        LinkedList<Node> queue = new LinkedList<>();
//        queue.add(root);
//
//        while(!queue.isEmpty()){
//            int size = queue.size();
//
//            Node first = queue.poll();
//
//            if(first.left != null){
//                queue.add(first.left);
//            }
//
//            if(first.right != null){
//                queue.add(first.right);
//            }
//
//            for (int i = 0; i < size - 1; i++){
//                Node poll = queue.poll();
//                first.next = poll;
//                if(poll.left != null){
//                    queue.add(poll.left);
//                }
//                if(poll.right != null){
//                    queue.add(poll.right);
//                }
//                first = poll;
//            }
//
//        }
//
//        return root;
//    }

    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }

    /**
     *      这里要先连接 右子树
     * @param root
     * @param next
     */
    public void dfs(Node root, Node next){

        if(root == null){
            return;
        }

        root.next = next;

        if(root.left != null && root.right != null){
            dfs(root.right, getNode(next));
            dfs(root.left, root.right);
        }else if(root.left == null){
            dfs(root.right, getNode(next));
        }else{
            dfs(root.left, getNode(next));
        }

    }

    public Node getNode(Node root){
        while(root != null){
            if(root.left != null){
                return root.left;
            }
            if(root.right != null){
                return root.right;
            }
            root = root.next;
        }
        return null;
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
