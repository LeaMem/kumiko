package com.lea.leet.forjob;

import com.lea.leet.alg.base.ListNode;

public class ForJob141 {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode f = head;
        ListNode s = head.next;

        while (s != null) {
            if (s == f) {
                return true;
            }
            s = s.next;
            if (s != null) {
                s = s.next;
            }
            f = f.next;
        }

        return false;
    }

}
