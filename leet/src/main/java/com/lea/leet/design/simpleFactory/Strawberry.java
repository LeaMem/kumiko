package com.lea.leet.design.simpleFactory;

public class Strawberry extends Fruit {


    @Override
    public void grow() {
        System.out.println("Strawberry grow");
    }

    @Override
    public void harvest() {
        System.out.println("Strawberry harvest");
    }

    @Override
    public void plant() {
        System.out.println("Strawberry plant");
    }
}
