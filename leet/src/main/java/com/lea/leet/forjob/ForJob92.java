package com.lea.leet.forjob;

import com.lea.leet.alg.base.ListNode;

public class ForJob92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode k = head;

        ListNode dummy = null;
        int index = 1;
        ListNode h = head;
        ListNode t = head;
        while (index < left && h != null) {
            if (dummy == null) {
                dummy = h;
            } else {
                dummy = dummy.next;
            }
            h = h.next;
            t = h;
            index++;
        }

        while (index < right && t != null) {
            t = t.next;
            index++;
        }

        if (h != null && t != null) {
            ListNode pre = t.next;
            while (h != t) {
                ListNode tmp = h.next;
                h.next = pre;
                pre = h;
                h = tmp;
            }
            t.next = pre;
            if (dummy != null) {
                dummy.next = t;
            } else {
                k = t;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.create();
        ForJob92 forJob92 = new ForJob92();
        ListNode listNode1 = forJob92.reverseBetween(listNode, 1, 2);

    }

}
