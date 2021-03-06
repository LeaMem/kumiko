package com.lea.leet.alg.base;

import java.util.Scanner;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }


    public static ListNode create() {

        Scanner scanner = new Scanner(System.in);

        ListNode head = new ListNode(0);
        ListNode tail = head;

        while (scanner.hasNext()) {
            int val = scanner.nextInt();
            ListNode listNode = new ListNode(val);
            tail.next = listNode;
            tail = listNode;
        }
        scanner.close();
        return head.next;
    }

    public static void print(ListNode root) {
        ListNode tmp = root;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {

    }

}
