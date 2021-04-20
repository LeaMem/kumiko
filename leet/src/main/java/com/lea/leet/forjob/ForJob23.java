package com.lea.leet.forjob;

import com.lea.leet.alg.base.ListNode;

import java.util.Arrays;
import java.util.Collections;

public class ForJob23 {

    public static void main(String[] args) {
        ForJob23 forJob23 = new ForJob23();

        ListNode[] listNodes = new ListNode[3];
        for (int i = 0; i < 3; i++) {
            listNodes[i] = ListNode.create();
        }

        ListNode listNode = forJob23.mergeKLists(listNodes);
        System.out.println(listNode);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int start, int end){

        if(start == end){
            return lists[start];
        }

        if(start > end){
            return null;
        }

        int mid = (start + end) / 2;
        ListNode left = merge(lists, start, mid);
        ListNode right = merge(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        while (l1 != null) {
            dummy.next = l1;
            l1 = l1.next;
            dummy = dummy.next;
        }
        while (l2 != null) {
            dummy.next = l2;
            l2 = l2.next;
            dummy = dummy.next;
        }
        return tmp.next;
    }
}
