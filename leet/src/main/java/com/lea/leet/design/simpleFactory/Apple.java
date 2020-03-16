package com.lea.leet.design.simpleFactory;

public class Apple extends Fruit {

    @Override
    public void grow() {
        System.out.println("apple grow");
    }

    @Override
    public void harvest() {
        System.out.println("apple harvest");
    }

    @Override
    public void plant() {
        System.out.println("apple plant");
    }
}
