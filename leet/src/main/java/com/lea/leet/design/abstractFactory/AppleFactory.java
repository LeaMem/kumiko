package com.lea.leet.design.abstractFactory;

public class AppleFactory implements Factory {

    @Override
    public Phone createPhone() {
        return new ApplePhone();
    }

    @Override
    public Computer createComputer() {
        return new AppleComputer();
    }
}
