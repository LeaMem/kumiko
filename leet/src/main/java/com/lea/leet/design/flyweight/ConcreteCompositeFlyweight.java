package com.lea.leet.design.flyweight;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ConcreteCompositeFlyweight extends FlyWeight {

    private HashMap files = new HashMap();
    private FlyWeight flyWeight;

    public void add(Character key, FlyWeight flyWeight) {
        files.put(key, flyWeight);
    }


    @Override
    public void operation(String state) {
        FlyWeight flyWeight = null;
        for (Iterator it = files.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry e = (Map.Entry) it.next();
            flyWeight = (FlyWeight) e.getValue();
            flyWeight.operation(state);
        }
    }
}
