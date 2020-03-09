package com.lea.leet.alg;

import com.lea.leet.alg.base.ListNode;

public class Solution147 {

    public ListNode insertionSortList(ListNode head) {

        ListNode dummy = new ListNode(0);

        while (head != null) {

            ListNode tmp = head.next;
            ListNode it = dummy.next;
            ListNode pre = dummy;

            /**
             *      这里可以优化
             */
            while(it != null && it.val < head.val){
                it = it.next;
                pre = pre.next;
            }

            pre.next = head;
            head.next = it;
            head = tmp;

        }

        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode listNode = ListNode.create();

        Solution147 solution147 = new Solution147();
        ListNode list = solution147.insertionSortList(listNode);

        ListNode.print(list);

    }

}
