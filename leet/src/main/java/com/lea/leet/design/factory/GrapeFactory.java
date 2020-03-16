package com.lea.leet.design.factory;

import com.lea.leet.design.simpleFactory.Fruit;
import com.lea.leet.design.simpleFactory.Grape;

public class GrapeFactory extends FruitFactory {

    @Override
    public Fruit newInstance() {
        return new Grape();
    }
}
