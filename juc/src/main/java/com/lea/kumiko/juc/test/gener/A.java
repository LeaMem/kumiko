package com.lea.kumiko.juc.test.gener;

import com.lea.kumiko.juc.bas.Person;
import com.lea.kumiko.juc.test.TestOne;
import com.lea.kumiko.juc.test.TestOne.TestSecond;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class A  {

    private A(){

    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
//        Person person = Person.class.newInstance();
//        System.out.println(person);
        Class<?> aClass = Class.forName("com.lea.kumiko.juc.bas.Person");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Object o = declaredConstructor.newInstance(null);
        System.out.println(o);

//        Object o = aClass.newInstance();
//        System.out.println(o);
//        System.out.println(aClass);
    }

}
