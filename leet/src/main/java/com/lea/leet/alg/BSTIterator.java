package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.LinkedList;

public class BSTIterator {

    private LinkedList<TreeNode> stack;

    public BSTIterator(TreeNode root){
        stack = new LinkedList<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    public int next(){
        TreeNode root = stack.pop();
        TreeNode tmp = root.right;
        while(tmp != null){
            stack.push(tmp);
            tmp = tmp.left;
        }
        return root.val;
    }



//    private LinkedList<TreeNode> stack = new LinkedList<>();
//    private TreeNode tmp;
//
//
//    public BSTIterator(TreeNode root) {
//        if (root != null) {
//            stack.push(root);
//            tmp = root;
//        }
//    }
//
//    /**
//     * @return the next smallest number
//     */
//    public int next() {
//
//        while (tmp != null || !stack.isEmpty()) {
//
//            while (tmp != null) {
//                tmp = tmp.left;
//                stack.push(tmp);
//            }
//
//            tmp = stack.pop();
//
//            if (tmp != null) {
//
//                int res = tmp.val;
//                tmp = tmp.right;
//
//                if (tmp != null) {
//                    stack.push(tmp);
//                }
//
//                return res;
//            }
//        }
//
//        return -1;
//    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(7);
        TreeNode three = new TreeNode(3);
        TreeNode fifteen = new TreeNode(15);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        root.left = three;
        root.right = fifteen;
        fifteen.left = nine;
        fifteen.right = twenty;

        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            int res = iterator.next();
            System.out.println(res);
        }
    }

}
