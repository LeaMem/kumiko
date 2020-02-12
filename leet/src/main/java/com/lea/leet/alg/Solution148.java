package com.lea.leet.alg;

import com.lea.leet.alg.base.ListNode;


public class Solution148 {

    public ListNode sortList(ListNode head) {

        int len = length(head);

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        for (int i = 1; i < len; i *= 2) {

            ListNode tmp = dummy;

            for (int j = 0; j + i < len; j += 2 * i) {

                ListNode first = tmp.next;
                ListNode second = tmp.next;

                for (int k = 0; k < i; k++) {
                    second = second.next;
                }

                int f = 0, s = 0;
                while (f < i && s < i && second != null) {
                    if (first.val < second.val) {
                        tmp.next = first;
                        tmp = tmp.next;
                        first = first.next;
                        f++;
                    } else {
                        tmp.next = second;
                        tmp = tmp.next;
                        second = second.next;
                        s++;
                    }
                }

                while (f < i) {
                    tmp.next = first;
                    tmp = tmp.next;
                    first = first.next;
                    f++;
                }

                while (s < i && second != null) {
                    tmp.next = second;
                    tmp = tmp.next;
                    second = second.next;
                    s++;
                }

                tmp.next = second;

            }


        }

        return dummy.next;
    }


    public int length(ListNode root) {
        int n = 0;
        if (root == null) {
            return 0;
        }
        while (root != null) {
            root = root.next;
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.create();

        Solution148 solution148 = new Solution148();

        head = solution148.sortList(head);


        ListNode.print(head);
    }


}
