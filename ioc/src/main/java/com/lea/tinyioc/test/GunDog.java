package com.lea.tinyioc.test;

public class GunDog implements Dog {
    @Override
    public void info() {
        System.out.println("我是一只狗");
    }

    @Override
    public void run() {
        System.out.println("我迅速奔跑");
    }


}
