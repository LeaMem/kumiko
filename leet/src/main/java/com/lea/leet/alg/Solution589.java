package com.lea.leet.alg;

import com.lea.leet.alg.base.Node;

import java.util.ArrayList;
import java.util.List;

public class Solution589 {

    public List<Integer> preorder(Node root) {

        List<Integer> list = new ArrayList<>();

        if(root == null){
            return list;
        }

        preTraverse(root, list);
        return list;
    }

    public void preTraverse(Node root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        for(Node node : root.children){
            preTraverse(node, list);
        }
    }

}
