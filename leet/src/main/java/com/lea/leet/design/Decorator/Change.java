package com.lea.leet.design.Decorator;

public class Change extends GreatSage {

    private GreatSage sage;

    public Change(GreatSage sage) {
        this.sage = sage;
    }

    @Override
    void move() {
        sage.move();
    }
}
