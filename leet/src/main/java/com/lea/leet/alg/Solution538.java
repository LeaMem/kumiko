package com.lea.leet.alg;

import com.lea.leet.alg.base.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 *      被别人给秀了
 *      用后续遍历又快又简单，我竟然不会逆向思维
 */
public class Solution538 {


    public TreeNode convertBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        midOrder(root, list);

        traverse(root, list);

        return root;
    }

    public void traverse(TreeNode root, List<Integer> list) {
        if (root != null) {
            traverse(root.left, list);

            int index = find(list, root.val);
            for (int i = index + 1; i < list.size(); i++) {
                root.val += list.get(i);
            }

            traverse(root.right, list);
        }
    }

    public int find(List<Integer> list, int val) {

        int l = 0;
        int r = list.size() - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) >= val) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public void midOrder(TreeNode root, List<Integer> list) {

        if (root != null) {
            midOrder(root.left, list);
            list.add(root.val);
            midOrder(root.right, list);
        }

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t13 = new TreeNode(13);

        root.left = t2;
        root.right = t13;

        Solution538 solution538 = new Solution538();
        TreeNode t = solution538.convertBST(root);
        System.out.println(t.val);
    }


}
