package com.lea.leet.design.bridge;

public class Boeing extends AirplaneMaker{

    @Override
    public void produce() {
        System.out.println("Boeing produced.");
    }
}
