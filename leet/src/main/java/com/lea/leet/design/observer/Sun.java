package com.lea.leet.design.observer;

import java.util.Observable;

public class Sun extends Observable {

    public void rise(){
        System.out.println("Sun rise.");

        //设置被观察者的状态标记，表示它发生了变化
        this.setChanged();

        //通知观察者该变化
        this.notifyObservers();

    }

}
