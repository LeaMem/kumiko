package com.lea.leet.design.flyweight;

public class FlyWeightTest {

    public static void main(String[] args) {

        String a = "hello";
        String b = "hell" + "o";
        String c = new String("hello");
        System.out.println(a == b);
        System.out.println(a == c);

    }

}
