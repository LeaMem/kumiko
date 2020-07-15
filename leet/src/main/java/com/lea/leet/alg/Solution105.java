package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;


public class Solution105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return create(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode create(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end){
        if(p_start > p_end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[p_start]);
        //偏移
        int k = 0;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == preorder[p_start]){
                k = i - i_start;
                break;
            }
        }

        root.left = create(preorder, p_start + 1, p_start + k, inorder, i_start, i_start + k - 1);
        root.right = create(preorder, p_start + 1 + k, p_end, inorder, i_start + k + 1, i_end);

        return root;
    }


    public static void main(String[] args) {

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Solution105 solution105 = new Solution105();
        TreeNode treeNode = solution105.buildTree(preorder, inorder);

        System.out.println(treeNode);
    }

}
