package com.lea.leet.alg;

public class MinStack {

    private TNode head;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.head = null;
    }

    public void push(int x) {
        TNode tNode = new TNode(x);
        tNode.next = head;
        this.head = tNode;
    }

    public void pop() {
        this.head = this.head.next;
    }

    public int top() {
        return this.head.val;
    }

    public int getMin() {

        TNode tmp = this.head;
        int min = Integer.MAX_VALUE;
        while (tmp != null) {
            min = Math.min(min, tmp.val);
            tmp = tmp.next;
        }

        return min;
    }

    public static class TNode {

        public int val;
        public TNode next;

        public TNode(int val) {
            this.val = val;
        }
    }

}
