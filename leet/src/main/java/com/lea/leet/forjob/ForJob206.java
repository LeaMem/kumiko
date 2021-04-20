package com.lea.leet.forjob;

import com.lea.leet.alg.base.ListNode;

public class ForJob206 {

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;

        while (head.next != null) {
            ListNode t = head.next;
            head.next = pre;
            pre = head;
            head = t;
        }

        head.next = pre;

        return head;
    }

}
