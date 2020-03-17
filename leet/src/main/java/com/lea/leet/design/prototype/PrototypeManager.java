package com.lea.leet.design.prototype;

import java.util.Vector;

public class PrototypeManager {

    private Vector objects = new Vector();

    public void add(Prototype object){
        objects.add(object);
    }

    public Prototype get(int i){
        return (Prototype) objects.get(i);
    }

    public int getSize(){
        return objects.size();
    }


    public static void main(String[] args) {

        Prototype prototype = new ConcretePrototype();
        Prototype copyType = prototype.clone();

        PrototypeManager mgr = new PrototypeManager();
        mgr.add(copyType);

    }
}
