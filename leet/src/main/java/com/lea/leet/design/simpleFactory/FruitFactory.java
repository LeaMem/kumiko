package com.lea.leet.design.simpleFactory;

public class FruitFactory {

    public static Fruit newInstance(String name) {
        switch (name) {
            case "apple":
                return new Apple();
            case "grape":
                return new Grape();
            case "strawberry":
                return new Strawberry();
            default:
                throw new Error("未实现");
        }
    }

    public static void main(String[] args) {
        Fruit apple = FruitFactory.newInstance("apple");
        apple.grow();
        apple.harvest();
        apple.plant();

        Fruit grape = FruitFactory.newInstance("grape");
        grape.grow();
        grape.harvest();
        grape.plant();

    }

}
