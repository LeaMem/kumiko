package com.lea.leet.forjob;

import com.lea.leet.alg.base.ListNode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ForJobT92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode f = dummy;
        ListNode s = dummy.next;

        for (int i = 1; i < left; i++) {
            f = f.next;
            s = s.next;
        }

        for (int i = left; i < right; i++) {
            ListNode next = s.next;
            s.next = next.next;
            next.next = f.next;
            f.next = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.create();
        ForJobT92 forJobT92 = new ForJobT92();
        ListNode listNode1 = forJobT92.reverseBetween(listNode, 2, 4);
        ListNode.print(listNode1);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.submit(null);
    }

}
