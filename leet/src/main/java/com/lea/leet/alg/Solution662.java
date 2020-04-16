package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution662 {

    private Map<Integer, WidthHelper> map = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {

        dfs(root, 0, 0);

        int sum = 0;
        for(int level : map.keySet()){
            WidthHelper widthHelper = map.get(level);
            sum = Math.max(widthHelper.right - widthHelper.left + 1, sum);
        }

        return sum;
    }

    /**
     *      维护层和索引数
     * @param root
     * @param level
     * @param index
     */
    public void dfs(TreeNode root, int level, int index){

        if(root == null){
            return;
        }

        if(map.containsKey(level)){
            //左边有了
            WidthHelper widthHelper = map.get(level);
            widthHelper.right = index;
        }else{
            WidthHelper widthHelper = new WidthHelper();
            widthHelper.left = index;
            widthHelper.right = index;
            map.put(level, widthHelper);
        }

        level += 1;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        dfs(root.left, level, left);
        dfs(root.right, level, right);
    }

    public static class WidthHelper{
        public int left;
        public int right;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);
        TreeNode three2 = new TreeNode(3);
        TreeNode nine = new TreeNode(9);

        root.left = three;
        root.right = two;
        three.left = five;
        three.right = three2;
        two.right = nine;

        int result = new Solution662().widthOfBinaryTree(root);
        System.out.println(result);
    }
}


