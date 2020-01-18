package com.lea.leet.alg;

import com.lea.leet.alg.base.Node;

import java.util.Arrays;

public class Solution559 {

    public int maxDepth(Node root) {

        if (root == null) {
            return 0;
        }

        if (root.children == null || root.children.size() == 0) {
            return 1;
        }

        int sum = 1;

        int max = Integer.MIN_VALUE;
        for (Node node : root.children) {
            max = Math.max(max, maxDepth(node));
        }
        return sum + max;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        node.children = Arrays.asList(two, three, four);
        three.children = Arrays.asList(five, six);

        int i = new Solution559().maxDepth(node);
        System.out.println(i);
    }

}
