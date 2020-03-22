package com.lea.leet.design.flyweight;


public class ConcreteFlyWeight extends FlyWeight {

    private Character intrinsicState;

    public ConcreteFlyWeight(Character intrinsicState) {
        this.intrinsicState = intrinsicState;
    }


    @Override
    public void operation(String state) {
        System.out.println("\tIntrisic State="
                + intrinsicState
                + ", Extriinsic State=" + state);
    }
}
