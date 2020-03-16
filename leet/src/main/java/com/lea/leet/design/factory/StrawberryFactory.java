package com.lea.leet.design.factory;

import com.lea.leet.design.simpleFactory.Fruit;
import com.lea.leet.design.simpleFactory.Strawberry;

public class StrawberryFactory extends FruitFactory {

    @Override
    public Fruit newInstance() {
        return new Strawberry();
    }

    public static void main(String[] args) {

        FruitFactory appleFac = new AppleFactory();
        Fruit apple = appleFac.newInstance();
        apple.grow();
        apple.harvest();
        apple.plant();

        FruitFactory strawberryFac = new StrawberryFactory();
        Fruit strawberry = strawberryFac.newInstance();
        strawberry.grow();
        strawberry.harvest();
        strawberry.plant();

    }
}
