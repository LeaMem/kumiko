package com.lea.kumiko.juc.bas;

public class Student extends Person {


    private String name;

    public Student() {

    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


}
