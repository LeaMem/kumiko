package com.lea.kumiko.juc.bas;

public class BaseI<T> {

   private T[][] tt;

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
