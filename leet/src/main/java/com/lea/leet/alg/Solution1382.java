package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution1382 {

    private Map<Integer, Integer> heightMap = new HashMap<>();


    public TreeNode balanceBST(TreeNode root) {
        return null;
    }

    public Integer getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return heightMap.get(root.val);
    }

    public TreeNode leftRotate(TreeNode root) {
        TreeNode x = root.left;
        root.left = x.right;
        x.right = root;

        //设置高度
        int pHeight = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        int xHeight = Math.max(pHeight, getHeight(root.left)) + 1;

        heightMap.put(root.val, pHeight);
        heightMap.put(x.val, xHeight);

        return x;
    }

    public TreeNode rightRotate(TreeNode root) {
        TreeNode x = root.right;
        root.right = x.left;
        x.left = root;

        //设置高度
        int pHeight = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        int xHeight = Math.max(pHeight, getHeight(x.right)) + 1;

        heightMap.put(root.val, pHeight);
        heightMap.put(x.val, xHeight);

        return x;
    }

    public TreeNode rightLeftRotate(TreeNode root) {
        root.right = leftRotate(root.right);
        return rightRotate(root);
    }

    public TreeNode leftRightRotate(TreeNode root) {
        root.left = rightRotate(root.left);
        return leftRotate(root);
    }


    public TreeNode insert(TreeNode root, int key) {

        LinkedList<TreeNode> stack = new LinkedList<>();

        if (root == null) {
            root = new TreeNode(key);
            stack.push(root);
        } else {
            TreeNode p = root;
            while (p != null) {
                stack.push(p);
                int cmp = key - p.val;
                if (cmp == 0) {
                    break;
                } else if (cmp < 0) {
                    if (p.left == null) {
                        p.left = new TreeNode(key);
                        stack.push(p.left);
                        break;
                    } else {
                        p = p.left;
                    }
                } else {
                    if (p.right == null) {
                        p.right = new TreeNode(key);
                        stack.push(p.right);
                    } else {
                        p = p.right;
                    }
                }
            }
        }

    }

    private void fixAfterInsert(TreeNode root, int key){
        TreeNode p = root;

    }

}
