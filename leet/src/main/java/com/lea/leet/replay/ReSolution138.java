package com.lea.leet.replay;


import com.lea.leet.alg.Solution138.Node;

import java.util.HashMap;
import java.util.Map;

public class ReSolution138 {

    public Node copyRandomList(Node head) {

        Map<Node, Node> map = new HashMap<>();
        Node it = head;
        while (it != null) {
            map.put(it, new Node(it.val));
            if (it.random != null) {
                map.put(it.random, new Node(it.random.val));
            }
            it = it.next;
        }

        Node dummy = new Node(0);
        Node tail = dummy;
        while (head != null) {
            Node node = map.get(head);
            tail.next = node;
            Node random = head.random;
            if (map.get(random) != null) {
                node.random = map.get(random);
            }
            head = head.next;
            tail = tail.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);
        Node node0 = new Node(0);
        Node node4 = new Node(4);
        Node node2 = new Node(2);

        node7.next = node13;
        node13.next = node11;
        node11.next = node10;
        node10.next = node1;
        node13.random = node0;
        node11.random = node4;
        node10.random = node2;
        node1.random = node0;

        ReSolution138 reSolution138 = new ReSolution138();
        Node node = reSolution138.copyRandomList(node7);
        System.out.println(node);
    }

}
