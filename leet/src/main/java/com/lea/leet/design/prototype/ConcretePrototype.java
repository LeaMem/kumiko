package com.lea.leet.design.prototype;

public class ConcretePrototype implements Prototype {


    @Override
    public synchronized Prototype clone() {
        Prototype tmp = null;
        try {
            tmp = (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return tmp;
    }
}
