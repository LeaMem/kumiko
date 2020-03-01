package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

public class Solution222Binary {

    public int countNodes(TreeNode root) {

        if(root == null){
            return 0;
        }

        int height = height(root);

        // 最后一层最多
        int l = 1;
        int r = (int) Math.pow(2, height);

        while(l < r){

            int mid = (l + r) / 2;

            boolean canReach = canReach(root, height, mid);

            if(canReach){
                l = mid + 1;
            }else{
                r = mid;
            }

        }


        return (int) (Math.pow(2, height) - 1 + l);

    }

    public boolean canReach(TreeNode root, int height, int index){

        int l = 1;
        int r = (int) Math.pow(2, height);

        for(int i = 0; i < height; i++){
            int mid = (l + r) / 2;
            if(mid > index){
                r = mid;
                root = root.left;
            }else{
                l = mid + 1;
                root = root.right;
            }
        }
        return root != null;
    }

    public int height(TreeNode root){

        int height = 0;
        while(root.left != null){
            height++;
            root = root.left;
        }

        return height;
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;

        int i = new Solution222Binary().countNodes(t1);
        System.out.println(i);

    }

}
