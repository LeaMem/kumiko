package com.lea.kumiko.juc.bas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.LockSupport;

public class Person {

    private String name;

    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        System.out.println(unsafe);

        Person person = new Person();
        Field name = Person.class.getDeclaredField("name");
        long nameOffSet = unsafe.objectFieldOffset(name);
        unsafe.putObject(person, nameOffSet, "kitty");
        System.out.println(person.getName());

    }
}
