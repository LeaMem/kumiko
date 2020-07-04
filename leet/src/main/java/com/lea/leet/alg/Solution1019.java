package com.lea.leet.alg;

import com.lea.leet.alg.base.ListNode;

import java.util.LinkedList;

public class Solution1019 {

    public int[] nextLargerNodes(ListNode head) {

        LinkedList<Pair> stack = new LinkedList<>();

        int[] ans = new int[len(head)];

        int index = 0;
        while (head != null) {

            //维护一个递减的栈
            while(!stack.isEmpty() && stack.peek().val < head.val){
                Pair pop = stack.pop();
                ans[pop.index] = head.val;
            }

            stack.push(new Pair(index, head.val));

            head = head.next;
            index++;
        }


        return ans;
    }

    public int len(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static class Pair {

        public int index;
        public int val;

        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

}
