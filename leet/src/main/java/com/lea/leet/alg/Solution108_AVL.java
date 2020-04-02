package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

import static com.lea.leet.alg.Solution108.midOrder;

public class Solution108_AVL {

    Map<Integer, Integer> heightMap = new HashMap<>();


    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        for (int it : nums) {
            root = insert(root, it);
        }
        return root;
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return heightMap.get(node.val);
    }

    public TreeNode rightRotate(TreeNode p) {
        TreeNode x = p.right;
        p.right = x.left;
        x.left = p;

        int pHeight = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        int xHeight = Math.max(pHeight, getHeight(x.right)) + 1;
        heightMap.put(p.val, pHeight);
        heightMap.put(x.val, xHeight);

        return x;
    }

    public TreeNode leftRotate(TreeNode p) {
        TreeNode x = p.left;
        p.left = x.right;
        x.right = p;

        int pHeight = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        int xHeight = Math.max(getHeight(x.left), pHeight) + 1;
        heightMap.put(p.val, pHeight);
        heightMap.put(x.val, xHeight);
        return x;
    }

    public TreeNode rightLeftRotate(TreeNode p) {
        p.left = rightRotate(p.left);
        return leftRotate(p);
    }

    public TreeNode leftRightRotate(TreeNode p) {
        p.right = leftRotate(p.right);
        return rightRotate(p);
    }

    public TreeNode insert(TreeNode root, int key) {

        if (root == null) {
            heightMap.put(key, 1);
            return new TreeNode(key);
        } else {

            int cmp = key - root.val;

            if (cmp > 0) {

                root.right = insert(root.right, key);
                if (getHeight(root.right) - getHeight(root.left) == 2) {

                    //插到最右边
                    if (key > root.right.val) {
                        root = rightRotate(root);
                    } else {
                        root = leftRightRotate(root);
                    }
                }

            } else if (cmp < 0) {

                root.left = insert(root.left, key);
                if (getHeight(root.left) - getHeight(root.right) == 2) {

                    if (key > root.left.val) {
                        root = rightLeftRotate(root);
                    } else {
                        root = leftRightRotate(root);
                    }

                }

            }

        }

        //忘记维护height了
        int height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        heightMap.put(root.val, height);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        Solution108_AVL solution108 = new Solution108_AVL();
        TreeNode root = solution108.sortedArrayToBST(nums);

        midOrder(root);
    }

}
