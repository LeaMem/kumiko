package com.lea.leet.design.adapter;

public interface Target {

    //adaptee能提供110v
    void getPower110v();

    //客户端需要220v
    void getPower220v();

}
