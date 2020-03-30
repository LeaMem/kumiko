package com.lea.leet.design.Decorator;

public class Flower extends Change {

    public Flower(GreatSage sage) {
        super(sage);
    }

    @Override
    void move() {
        System.out.println("Flower Move");
    }
}
