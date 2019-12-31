package com.lea.kumiko.juc.bas;

public class Student extends Person {


    private String name;

    public Student(String name) {
        super(name);
        this.name = "student" + name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Person person = new Student("ding");
        System.out.println(person.getName());
    }
}
