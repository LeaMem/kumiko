package com.lea.leet.alg;


public class Solution430 {

    public Node flatten(Node head) {

        if (head == null) {
            return null;
        }

        Node tmp = head;
        while (tmp != null) {
            if (tmp.child != null) {
                tmp = flat(tmp);
            } else {
                tmp = tmp.next;
            }
        }

        return head;
    }

    public Node flat(Node head) {

        Node child = head.child;
        Node next = head.next;
        Node childTail = tail(child);

        head.next = child;
        child.prev = head;

        if (childTail != null) {
            childTail.next = next;
        }

        if (next != null) {
            next.prev = childTail;
        }

        head.child = null;

        return head;
    }

    public static Node tail(Node head) {
        while (head != null && head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void create(Node head, int next, Node child) {

        Node tmp = new Node(next);

        if (child != null) {
            tmp.child = child;
        }

        Node tail = tail(head);

        tail.next = tmp;
        tmp.prev = tail;

    }

    public static void main(String[] args) {

        Node thirdLevel = new Node(11);
        create(thirdLevel, 12, null);

        Node secondLevel = new Node(7);
        create(secondLevel, 8, thirdLevel);
        create(secondLevel, 9, null);
        create(secondLevel, 10, null);

        Node head = new Node(1);
        create(head, 2, null);
        create(head, 3, secondLevel);
        create(head, 4, null);
        create(head, 5, null);
        create(head, 6, null);

        System.out.println(thirdLevel);
    }

}
