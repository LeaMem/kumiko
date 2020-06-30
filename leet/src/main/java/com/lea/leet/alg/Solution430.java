package com.lea.leet.alg;


import com.lea.leet.alg.base.ListNode;


//todo 430没有做
public class Solution430 {

    public Node flatten(Node head) {

        if(head == null){
            return null;
        }

        if(head.child != null){

            Node next = head.next;
            Node tail = tail(head.child);

            head.next = head.child;
            head.child.prev = head;

            tail.next = next;
            next.prev = tail;

        }

        Node tmp = head;
        while(tmp.next != null){
            flatten(tmp);
            tmp = tmp.next;
        }


        return head;
    }

    public Node tail(Node head){
        if(head != null && head.next != null){
            head = head.next;
        }
        return head;
    }

    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public static void main(String[] args) {



    }

}
