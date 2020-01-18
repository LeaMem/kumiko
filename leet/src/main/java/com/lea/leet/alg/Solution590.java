package com.lea.leet.alg;

import com.lea.leet.alg.base.Node;

import java.util.ArrayList;
import java.util.List;

public class Solution590 {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        postTraverse(root, list);
        return list;
    }

    public void postTraverse(Node root, List<Integer> list) {

        if (root == null) {
            return;
        }

        for (Node node : root.children) {
            postTraverse(node, list);
        }

        list.add(root.val);
    }

}
