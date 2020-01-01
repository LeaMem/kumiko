package com.lea.kumiko.juc.basic;

public class SomeObj {

    private Integer x;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public static void main(String[] args) {

        SomeObj someObj = new SomeObj();
        someObj.setX(10);

    }
}
