package com.lea.leet.alg;

import com.lea.leet.alg.base.ListNode;

public class Solution206 {


    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = null;

        while (head != null) {

            ListNode tmp = head;
            head = head.next;

            tmp.next = dummy;
            dummy = tmp;
        }


        return dummy;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.create();

        ListNode listNode1 = new Solution206().reverseList(listNode);

        System.out.println(listNode1);
    }

}
