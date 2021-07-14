package com.lea.kumiko.juc.test;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

public class TestOne implements IFirst{

    public String name;

    public Integer testSecond;

    @Override
    public void say() {

    }

    public static class TestSecond extends TestOne implements ISecond{

        protected Integer age;

        @Override
        public void cry() {

        }

        private static class TestThird extends TestSecond{

        }
    }

    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException {
        Class<Integer> integerClass = int.class;
        Class<Integer> integerClass1 = Integer.class;
        System.out.println(integerClass.isPrimitive());
        System.out.println(integerClass1.isPrimitive());

    }

}
