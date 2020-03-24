package com.lea.leet.design.bridge;

public abstract class Airplane {

    //飞机制造商
    protected AirplaneMaker maker;

    public Airplane(AirplaneMaker maker) {
        this.maker = maker;
    }


    public void fly(){
        //调用Airplane的produce()方法
        maker.produce();
    }


}
