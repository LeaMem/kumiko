package com.lea.kumiko.juc.bas;


import com.sun.xml.internal.bind.v2.TODO;

import java.util.concurrent.*;

/**
 *      https://www.jianshu.com/p/69a6ae850736
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
     *
     *     判断task状态，如果task还未执行，跳转到步骤2，否则，返回，程序结束；
     *
     *     通过CAS设置执行task的线程，设置成功，跳转到步骤3，否则，返回，程序结束；
     *
     *     执行callable.call方法，调用set方法设置call方法返回结果以及task状态；
     *
     *     设置当前运行当前task的线程为null；
     *
     *     判断当前task状态，如果task状态为正在中断或者已中断，调用Thread.yield()将线程从执行状态变为可执行状态。
     *
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

        try{
            Callable<V> c = callable;

            // 任务执行完成 callable 就设置成 null
            if(c != null && state ==NEW){
                V result;
                boolean ran;

                try{
                    result = c.call();
                    ran = true;
                } catch (Exception e) {
                    result = null;
                    ran =false;
                    setException(e);
                }
                if(ran){
                    set(result);
                }
            }
        }finally {

            /**
             *      todo 不懂
             *      运行器必须为非null，直到解决状态为止，以防止同时调用run（）
             */
            runner = null;

            //取消运行程序后必须重新读取状态，以防止
            //    泄漏的中断


        }

    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public V get() throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }


    /**
     *     // TODO: 2019/12/31 为什么要 CAS 操作状态 是为了响应中断的吧？
     *    除非已经设置了此 Future 或已将其取消，否则它将报告一个 ExecutionException，并将给定的 throwable 作为其原因。在计算失败时通过 run 方法内部调用此方法
     * @param t
     */
    protected void setException(Throwable t){
        // cas 设置 COMPLETING 状态
        if(UNSAFE.compareAndSwapInt(this, stateOffset, NEW, COMPLETING)){
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
    protected void set(V v){

        if(UNSAFE.compareAndSwapInt(this, stateOffset, NEW , COMPLETING)){
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
