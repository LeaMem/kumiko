package com.lea.leet.design.flyweight;

import java.util.HashMap;

public class FlyweightFactory {

    private HashMap files = new HashMap();

    //创建 复合享元 的工厂方法
    public FlyWeight factory(String compositeState) {
        ConcreteCompositeFlyweight compositeFlyweight = new ConcreteCompositeFlyweight();
        int length = compositeState.length();
        Character state = null;
        for (int i = 0; i < length; i++) {
            state = new Character(compositeState.charAt(i));
            System.out.println("factory(" + state + ")");
            compositeFlyweight.add(state, this.factory(state));
        }
        return compositeFlyweight;
    }

    //创建 单纯享元的工厂方法
    public FlyWeight factory(Character state) {
        if (files.containsKey(state)) {
            return (FlyWeight) files.get(state);
        } else {
            FlyWeight fly = new ConcreteFlyWeight(state);
            files.put(state, fly);
            return fly;
        }
    }

    public static void main(String[] args) {

        FlyweightFactory factory = new FlyweightFactory();

        String str = "abcda";
        FlyWeight com1 = factory.factory(str);
        FlyWeight com2 = factory.factory(str);
        com1.operation("Composite Call");
        com2.operation("Composite Call");
        System.out.println("com1==com2:"+(com1==com2));

        Character c = '1';
        FlyWeight pure1 = factory.factory(c);
        FlyWeight pure2 = factory.factory(c);
        pure1.operation("pure Call");
        pure2.operation("pure Call");
        System.out.println("pure1==pure2:"+(pure1==pure2));

    }

}
