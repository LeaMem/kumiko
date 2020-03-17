package com.lea.leet.design.adapter;

public class Adapter extends Adaptee implements Target {


    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void getPower110v() {
        adaptee.getPower110v();
    }

    @Override
    public void getPower220v() {
        System.out.println("get power: 220v");
    }

    public static void main(String[] args) {

        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);

        adapter.getPower110v();
        adapter.getPower220v();

    }
}
