package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

public class Solution236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null){
            return right;
        }

        if(right == null){
            return left;
        }

        return root;
    }


//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//
//        TreeNode parent = null;
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while(!queue.isEmpty() && root != null){
//            int size = queue.size();
//            for(int i = 0; i < size; i++){
//                TreeNode tmp = queue.poll();
//                if(parentOf(tmp, p) && parentOf(tmp, q)){
//                    parent = tmp;
//                }
//                if(tmp.left != null){
//                    queue.add(tmp.left);
//                }
//                if(tmp.right != null){
//                    queue.add(tmp.right);
//                }
//            }
//        }
//        return parent;
//    }

//    public boolean parentOf(TreeNode parent, TreeNode child){
//
//        if(parent == null){
//            return false;
//        }
//
//        if (parent == child){
//            return true;
//        }
//
//        boolean left = parentOf(parent.left, child);
//        if(left){
//            return true;
//        }
//
//        return parentOf(parent.right, child);
//    }

}
