package com.lea.leet.design.factory;

import com.lea.leet.design.simpleFactory.Apple;
import com.lea.leet.design.simpleFactory.Fruit;

public class AppleFactory extends FruitFactory {

    @Override
    public Fruit newInstance() {
        return new Apple();
    }
}
