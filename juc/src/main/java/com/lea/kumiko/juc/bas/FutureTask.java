package com.lea.kumiko.juc.bas;

import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

/**
 * https://segmentfault.com/a/1190000013843003
 * https://www.jianshu.com/p/69a6ae850736
 *
 * @param <V>
 */

/**
 *      堆栈，自旋锁，label 语法，LockSupport
 * @param <V>
 */
public class FutureTask<V> implements RunnableFuture<V> {


    /**
     * 状态转换过程
     * <p>
     * 1. NEW -> COMPLETING -> NORMAL
     */

    /**
     * 状态机状态
     */
    private volatile int state;

    private static final int NEW = 0;
    private static final int COMPLETING = 1;
    private static final int NORMAL = 2;
    private static final int EXCEPTIONAL = 3;
    private static final int CANCELLED = 4;
    private static final int INTERRUPTING = 5;
    private static final int INTERRUPTED = 6;

    /**
     * 包装的 callable
     */
    private Callable<V> callable;

    /**
     * 结果
     */
    private Object outCome;

    /**
     * 执行的线程
     */
    private volatile Thread runner;

    /**
     * todo 阻塞的节点
     */
    private volatile WaitNode waiters;

    /**
     * 第一个构造器
     *
     * @param callable
     */
    public FutureTask(Callable<V> callable) {
        if (callable == null) {
            throw new NullPointerException();
        }
        this.callable = callable;
        this.state = NEW;
    }

    public FutureTask(Runnable runnable, V result) {
        this.callable = Executors.callable(runnable, result);
        this.state = NEW;
    }


    /**
     *      将runner属性设置成当前正在执行run方法的线程
     * 调用callable成员变量的call方法来执行任务
     * 设置执行结果outcome, 如果执行成功, 则outcome保存的就是执行结果；如果执行过程中发生了异常, 则outcome中保存的就是异常，设置结果之前，先将state状态设为中间态
     * 对outcome的赋值完成后，设置state状态为终止态(NORMAL或者EXCEPTIONAL)
     * 唤醒Treiber栈中所有等待的线程
     * 善后清理(waiters, callable，runner设为null)
     * 检查是否有遗漏的中断，如果有，等待中断状态完成。
     */
    @Override
    public void run() {

        /**
         *   如果 state 不是 NEW 那就是说已经启动了
         *   如果 state == NEW && CAS 设置 runner 失败那也不行
         */
        // TODO: 2019/12/31 有什么情况没有设置state的值
        if (state != NEW || !UNSAFE.compareAndSwapObject(this, runnerOffset, null, Thread.currentThread())) {
            return;
        }

        try {

            //reload
            Callable<V> c = callable;

            // 任务执行完成 callable 就设置成 null
            // todo 任务没被 cancel 的时候才继续
            if (c != null && state == NEW) {
                V result;
                boolean ran;
                try {
                    result = c.call();
                    ran = true;
                } catch (Exception e) {
                    result = null;
                    ran = false;
                    //出现异常，更新状态
                    setException(e);
                }
                if (ran) {
                    set(result);
                }
            }
        } finally {

            /**
             *      todo 不懂
             *      运行器必须为非null，直到解决状态为止，以防止同时调用run（）
             */
            runner = null;

            //取消运行程序后必须重新读取状态，以防止
            //    泄漏的中断

            //reload， 因为防止 store_store 的 happens before
            int s = state;
            //已经中断了
            if (s >= INTERRUPTING) {
                handlePossibleCancellationInterrupt(s);
            }
        }
    }

    /**
     *      如果已经执行过 cancel return false
     *      否则 cas 比较
     * @param mayInterruptIfRunning
     * @return
     */
    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {

        // 不是new 的话 说明已经启动完成
        // state == NEW, cas 比较，mayInterrupt true 的话走 NEW -> INTERRUPTING -> INTERRUPTED
        // mayInterrupt false 的话走  NEW -> CANCELLED
        if (!(state == NEW && UNSAFE.compareAndSwapInt(this, stateOffset, NEW, mayInterruptIfRunning ? INTERRUPTING : CANCELLED))) {
            return false;
        }

        try {
            if (mayInterruptIfRunning) {
                try {
                    Thread t = runner;
                    //已经在启动了
                    if (t != null) {
                        t.interrupt();
                    }
                } finally {
                    //final state
                    UNSAFE.putOrderedInt(this, stateOffset, INTERRUPTED);
                }
            }
        } finally {
            //TODO finishCompletion()
        }
        return true;
    }

    @Override
    public boolean isCancelled() {
        return state >= CANCELLED;
    }

    @Override
    public boolean isDone() {
        return state != NEW;
    }

    @Override
    public V get() throws InterruptedException, ExecutionException {

        int s = state;
        if (s <= COMPLETING) {
            s = awaitDone(false, 0L);
        }

        return report(s);
    }

    @Override
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    private V report(int s) throws ExecutionException {
        Object x = outCome;
        if (s == NORMAL) {
            return (V) x;
        }
        if (s >= CANCELLED) {
            throw new CancellationException();
        }
        throw new ExecutionException((Throwable) x);
    }

    /**
     *      等待完成或者中断取消或者超时
     * @param timed
     * @param nanos
     * @return
     */
    private int awaitDone(boolean timed, long nanos) throws InterruptedException {
//        final long deadline = timed ? System.nanoTime() + nanos : 0L;
//        WaitNode q = null;
//        boolean queued = false;
//
//
//        for(;;){
//
//            if(Thread.interrupted()){
//                //todo removeWaiter(q);
//                removeWaiter(q);
//                throw new InterruptedException();
//            }
//
//            int s = state;
//            //任务已经完成 或者 取消
//            //这里的 q 不是一定是 null吗
//            if(s > COMPLETING){
//                if(q != null){
//                    q.thread = null;
//                }
//                return s;
//            }else if(s == COMPLETING){
//                Thread.yield();
//            }else if (q == null){
//                q = new WaitNode();
//            }else if (!queued){
//
//                //这是什么神仙操作
//                //todo 这里如果失败了怎样
//                queued = UNSAFE.compareAndSwapObject(this, waitersOffset, q.next = waiters, q);
//            }else if (timed){
//                nanos = deadline - System.nanoTime();
//                if(nanos <= 0L){
//                    //todo removeWaiter(q) 超时了
//                    removeWaiter(q);
//                    return state;
//                }
//                // LockSupport 是啥, 这是应该是具体的阻塞了
//                LockSupport.parkNanos(this, nanos);
//            }else{
//                LockSupport.park(this);
//            }
//
//        }

        final long deadline = timed ? System.nanoTime() + nanos : 0L;
        WaitNode q = null;
        boolean queued = false;
        for(;;){

            //监听中断
            if(Thread.interrupted()){
                removeWaiter(q);
                throw new InterruptedException();
            }

            //reload store-store
            int s = state;

            //任务已经完成,就不要阻塞了
            if(s > COMPLETING){
                //已经过了第一次for循环
                //todo
                if(q != null){
                    q.thread = null;
                }
                return s;
            }else if (s == COMPLETING){
                //自旋
                Thread.yield();
            }else if (q == null){
                //这里 state 只能是 NEW 了，说明任务还没启动或者正在run
                q = new WaitNode();
            }else if (!queued){
                //加入队列
                queued = UNSAFE.compareAndSwapObject(this, waitersOffset, q.next = waiters, q);
            }else if (timed){
                nanos = deadline - System.nanoTime();

                //已经超时了
                //todo 没看懂
                if(nanos <= 0L){
                    removeWaiter(q);
                    return state;
                }

                LockSupport.parkNanos(this, nanos);

            }else{
                LockSupport.park(this);
            }
        }
    }


    /**
     *      又是自旋
     * @param node
     */
    private void removeWaiter(WaitNode node) {
        //标记线程
        //这里判断是为了判断啥？已经别修改了吗？？不对吧，thread是唯一的
        //怪不得要判断 node 非空，如果 get 一开始就发现中断，那么就要判断了
        if (node != null) {
            node.thread = null;

            retry:
            for (; ; ) {
                for (WaitNode pred = null, q = waiters, s; q != null; q = s) {

                    s = q.next;

                    //继续往下走，找到打上标记的节点
                    if (q.thread != null) {
                        pred = q;
                    } else if (pred != null) {
                        //要移除的元素不在栈顶，并且找到了要移除的元素
                        //第一次 pred 是 null
                        pred.next = s;
                        //单线程链表删除节点是这样写，但是这里为了方式并发标记pred节点
                        if (pred.thread == null) {
                            continue retry;
                        }

                    } else if (!UNSAFE.compareAndSwapObject(this, waitersOffset, q, s)) {

                        //栈顶的节点就是要删除的

                        continue retry;
                    }
                }
                break;
            }
        }
    }


    private void finishCompletion() {

        for (WaitNode q; (q = waiters) != null; ) {
            if (UNSAFE.compareAndSwapObject(this, waitersOffset, q, null)) {
                for (; ; ) {
                    Thread t = q.thread;
                    if (t != null) {
                        q.thread = null;
                        LockSupport.unpark(t);
                    }
                    WaitNode next = q.next;
                    if (next == null) {
                        break;
                    }
                    q.next = null;
                    q = next;
                }
                break;
            }
        }

        callable = null;
    }

    /**
     *      todo    不懂
     * @param s
     */
    private void handlePossibleCancellationInterrupt(int s) {
        if (s == INTERRUPTING) {
            while (state == INTERRUPTING) {
                Thread.yield();
            }
        }
    }


    /**
     *     // TODO: 2019/12/31 为什么要 CAS 操作状态 是为了响应中断的吧？
     *    除非已经设置了此 Future 或已将其取消，否则它将报告一个 ExecutionException，并将给定的 throwable 作为其原因。在计算失败时通过 run 方法内部调用此方法
     * @param t
     */
    protected void setException(Throwable t) {
        // cas 设置 COMPLETING 状态
        if (UNSAFE.compareAndSwapInt(this, stateOffset, NEW, COMPLETING)) {
            outCome = t;

            UNSAFE.putOrderedInt(this, stateOffset, EXCEPTIONAL);

            // TODO: 2019/12/31 finishCompletion() 唤醒其他正在阻塞的线程

        }
    }


    /**
     *      TODO: 2019/12/31 为什么要 CAS 操作状态 是为了响应中断的吧？
     *      除非已经设置了此 Future 或已将其取消，否则将其结果设置为给定的值。在计算成功完成时通过 run 方法内部调用此方法。
     * @param v
     */
    protected void set(V v) {

        if (UNSAFE.compareAndSwapInt(this, stateOffset, NEW, COMPLETING)) {
            outCome = v;
            UNSAFE.putOrderedInt(this, stateOffset, NORMAL);

            //TODO finishCompletion
        }
    }

    /**
     * 等待节点，
     * todo 细节去看  Phaser, SynchronousQueue
     */
    static final class WaitNode {
        volatile Thread thread;
        volatile WaitNode next;

        public WaitNode() {
            thread = Thread.currentThread();
        }
    }


    /**
     * unsafe 操作机制
     * https://liuzhengyang.github.io/2017/05/11/cas/
     * https://www.cnblogs.com/daxin/p/3366606.html
     */
    private static final sun.misc.Unsafe UNSAFE;

    /**
     * state 的偏移量，用户 cas 操作
     */
    private static final long stateOffset;

    private static final long runnerOffset;

    private static final long waitersOffset;


    static {
        try {
            UNSAFE = sun.misc.Unsafe.getUnsafe();
            Class<?> k = FutureTask.class;

            stateOffset = UNSAFE.objectFieldOffset(k.getDeclaredField("state"));

            runnerOffset = UNSAFE.objectFieldOffset(k.getDeclaredField("runner"));

            waitersOffset = UNSAFE.objectFieldOffset(k.getDeclaredField("waiters"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
