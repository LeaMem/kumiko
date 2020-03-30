package com.lea.leet.alg;

import com.lea.leet.alg.base.ListNode;

public class Solution328 {

    public ListNode oddEvenList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode first = head;
        ListNode second = head.next;

        ListNode firstDummy = new ListNode(0);
        ListNode secondDummy = new ListNode(0);
        firstDummy.next = first;
        secondDummy.next = second;

        while (second != null) {

            ListNode firstTmp = second.next;

            first.next = firstTmp;

            if (firstTmp == null) {
                break;
            }

            first = first.next;

            second.next = first.next;
            second = second.next;
        }

        if (first != null) {
            first.next = secondDummy.next;
        }

        if (second != null) {
            second.next = null;
        }

        return firstDummy.next;
    }

    public static void main(String[] args) {

        ListNode listNode = ListNode.create();
        ListNode listNode1 = new Solution328().oddEvenList(listNode);

        ListNode.print(listNode1);

    }


}
