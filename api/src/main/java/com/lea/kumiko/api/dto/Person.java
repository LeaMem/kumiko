package com.lea.kumiko.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {


    private String name;

    private Integer age;

    public static void update(Person person){
        Person tmp = new Person();
        tmp.setName("tongtong");
        tmp.setAge(22);
        person = tmp;
    }

    public static void update(String s){
        s = "love kitty";
    }

    public static void main(String[] args) {

        while(true){
            System.out.println("kitty");
        }


    }
}
