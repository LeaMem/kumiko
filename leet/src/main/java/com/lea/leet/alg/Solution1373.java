package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

public class Solution1373 {

    int max = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return max;
    }


    public Res dfs(TreeNode root) {

        if (root == null) {
            return new Res(true, 0);
        }

        Res leftR = dfs(root.left);
        Res rightR = dfs(root.right);

        if (!leftR.ifBinary || !rightR.ifBinary) {
            return new Res(false, 0);
        }

        int tmp = 0;
        if ((root.left == null || root.left.val < root.val) && (root.right == null || root.right.val > root.val)) {
            tmp += root.val;
            tmp += leftR.data;
            tmp += rightR.data;
            max = Math.max(tmp, max);
            return new Res(true, tmp);
        } else {
            tmp = Math.max(leftR.data, rightR.data);
            max = Math.max(tmp, max);
            return new Res(false, tmp);
        }


    }


    public static class Res {

        public boolean ifBinary;

        public int data;

        public Res(boolean ifBinary, int data) {
            this.ifBinary = ifBinary;
            this.data = data;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode fourSecond = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        TreeNode twotwo = new TreeNode(2);
        TreeNode five = new TreeNode(5);
        TreeNode four3 = new TreeNode(4);
        TreeNode six = new TreeNode(6);

        root.left = fourSecond;
        root.right = three;
        fourSecond.left = two;
        fourSecond.right = four;

        three.left = twotwo;
        three.right = five;
        five.left = four3;
        five.right = six;

        Solution1373 solution1373 = new Solution1373();
        int res = solution1373.maxSumBST(root);
        System.out.println(res);


    }

}
