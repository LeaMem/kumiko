package com.lea.kumiko.juc.bas;

import sun.misc.Unsafe;

import java.io.Serializable;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;

public class AbstractQueuedSynchronizer
        extends AbstractOwnableSynchronizer implements Serializable {

    protected AbstractQueuedSynchronizer() {
    }

    static final class Node {

        static final Node SHARED = new Node();

        //是否是排他锁
        static final Node EXCLUSIVE = null;

        //线程被取消
        static final int CANCELLED = 1;

        //后序节点要唤醒?
        static final int SIGNAL = -1;

        //等待 condition
        static final int CONDITION = -2;

        static final int PROPAGATE = -3;

        volatile int waitStatus;

        volatile Node prev;

        volatile Node next;

        volatile Thread thread;

        Node nextWaiter;


        final boolean isShared() {
            return nextWaiter == SHARED;
        }

        final Node predecessor() throws NullPointerException {
            Node p = prev;
            if (p == null) {
                throw new NullPointerException();
            } else {
                return p;
            }
        }

        Node() {

        }

        Node(Thread thread, Node mode) {
            this.nextWaiter = mode;
            this.thread = thread;
        }

        Node(Thread thread, int waitStatus) {
            this.waitStatus = waitStatus;
            this.thread = thread;
        }
    }

    private transient volatile Node head;

    private transient volatile Node tail;

    private volatile int state;

    protected final int getState() {
        return state;
    }

    protected final void setState(int newState) {
        state = newState;
    }

    protected final boolean compareAndSetState(int expect, int update) {
        return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
    }

    static final long spinForTimeoutThreshold = 1000L;

    private Node enq(final Node node) {
        for (; ; ) {
            Node t = tail;
            if (t == null) {
                if (compareAndSetHead(new Node())) {
                    tail = head;
                }
            } else {

                //这里终归是要成功的
                node.prev = t;
                if(compareAndSetTail(t, node)){
                    t.next = node;
                    return t;
                }
            }
        }
    }

    /**
     *      入队列
     *
     * @param mode
     * @return
     */
    private Node addWaiter(Node mode){
        Node node = new Node(Thread.currentThread(), mode);
        Node pred = tail;
        if(pred != null){
            node.prev = pred;
            //尝试一次，不是每次都是高并发状态
            if(compareAndSetTail(pred, node)){
                pred.next = node;
                return node;
            }
        }
        enq(node);
        return node;
    }

    private void setHead(Node node){
        head = node;
        node.thread = null;
        node.prev = null;
    }

    //todo 这个不懂
    private void unparkSuccessor(Node node){
        int ws = node.waitStatus;
        if(ws < 0){

        }
    }

    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long stateOffset;
    private static final long headOffset;
    private static final long tailOffset;
    private static final long waitStatusOffset;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(AbstractQueuedSynchronizer.class.getDeclaredField("state"));
            headOffset = unsafe.objectFieldOffset(AbstractQueuedSynchronizer.class.getDeclaredField("head"));
            tailOffset = unsafe.objectFieldOffset(AbstractQueuedSynchronizer.class.getDeclaredField("tail"));
            waitStatusOffset = unsafe.objectFieldOffset(Node.class.getDeclaredField("waitStatus"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    private final boolean compareAndSetHead(Node update) {
        return unsafe.compareAndSwapObject(this, headOffset, null, update);
    }

    protected final boolean compareAndSetTail(Node expect, Node update) {
        return unsafe.compareAndSwapObject(this, tailOffset, expect, update);
    }

    private static boolean compareAndSetWaitStatus(Node node, int expect, int update){
        return unsafe.compareAndSwapInt(node, waitStatusOffset, expect, update);
    }


}
