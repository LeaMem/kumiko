package com.lea.tinyioc.test;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaGrammar;

import java.util.HashMap;
import java.util.Map;

public class Person {

    public static Map<String, Dog> map = new HashMap<>();

    public  Dog change(String key){
        Dog dog = map.get(key);
        dog = new Dog() {
            @Override
            public void info() {
                System.out.println("kkkk");
            }

            @Override
            public void run() {
                System.out.println("yyyy");
            }
        };
        return dog;
    }


    public static void main(String[] args) {

        Person person = new Person();

        map.put("1", new GunDog());

        Dog dog = map.get("1");

        dog.run();

        dog = person.change("1");

        dog.run();

        dog = map.get("1");

        dog.run();

    }
}
