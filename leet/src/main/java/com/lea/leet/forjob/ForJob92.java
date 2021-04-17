package com.lea.leet.forjob;

import com.lea.leet.alg.base.ListNode;

import java.util.List;

public class ForJob92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode h = head;
        ListNode t = head;
        int index = 0;

        //找到起始位置
        while (h != null && index < left) {
            h = h.next;
            t = h;
            index++;
        }

        //找到结束位置
        while(t != null && index < right){
            t = t.next;
            index++;
        }

        if(h != null && t != null){

            //reverse
            ListNode tmp = h;


        }



        return head;
    }

}
