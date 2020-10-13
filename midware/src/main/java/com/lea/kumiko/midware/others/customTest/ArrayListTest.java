package com.lea.kumiko.midware.others.customTest;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    static {
        System.out.println("静态代码块");
    }

    public static void printIt(){
        System.out.println("static method");
    }


    {
        System.out.println("name");
        String name = getName();
        System.out.println(name);
    }

    public ArrayListTest() {
        System.out.println("construct");
    }

    private String getName(){
        return "test";
    }

    public static void main(String[] args) {

        ArrayListTest arrayListTest = new ArrayListTest();

        ArrayListTest.printIt();

        List<String> list = new ArrayList<String>() {
            {
                add("ding");
            }
        };

        System.out.println(list.size());
    }

}
