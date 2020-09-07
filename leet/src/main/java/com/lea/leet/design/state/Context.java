package com.lea.leet.design.state;

public class Context {

    public static final ClosingState CLOSING_STATE = new ClosingState();
    public static final FaultState FAULT_STATE = new FaultState();
    public static final OpeningState OPENING_STATE = new OpeningState();
    public static final RunningState RUNNING_STATE = new RunningState();
    public static final StoppingState STOPPING_STATE = new StoppingState();


    private BaseState mBaseState;

    public BaseState getBaseState() {
        return mBaseState;
    }

    public void setBaseState(BaseState baseState) {
        this.mBaseState = baseState;
        this.mBaseState.setContext(this);
    }

    /**
     * 模拟电梯的运行方法
     */
    public Context run() {
        this.mBaseState.run();
        return this;
    }

    /**
     * 模拟电梯的停止方法
     */
    public Context stop() {
        this.mBaseState.stop();
        return this;
    }

    /**
     * 模拟电梯的开门方法
     */
    public Context open() {
        this.mBaseState.open();
        return this;
    }

    /**
     * 模拟电梯的关门方法
     */
    public Context close() {
        this.mBaseState.close();
        return this;
    }

    public static void main(String[] args) {

        Context context = new Context();
        context.setBaseState(new ClosingState());
        context.run().open().close();

        Context context1 = new Context();
        context1.setBaseState(new RunningState());
        context1.stop().open().run().open();

    }

}
