package com.lea.leet.alg;


import java.util.HashMap;
import java.util.Map;

public class Solution138 {

    public static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        Map<Node, Node> map = new HashMap<>();

        Node f = head;
        while (f != null) {
            map.put(f, new Node(f.val));
            Node random = f.random;
            if (random != null) {
                map.put(random, new Node(random.val));
            }
            f = f.next;
        }

        Node dummy = new Node(0);
        Node tail = dummy;
        Node tmp = head;
        while (tmp != null) {
            tail.next = map.get(tmp);
            tail.next.random = map.get(tmp.random);
            tail = tail.next;
            tmp = tmp.next;
        }

        return dummy.next;
    }

}
