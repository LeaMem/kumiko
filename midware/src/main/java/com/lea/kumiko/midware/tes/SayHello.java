package com.lea.kumiko.midware.tes;

public class SayHello implements Say{
    @Override
    public void say() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        int[] arr= new int[10];
        System.out.println(arr.getClass());

    }
}
