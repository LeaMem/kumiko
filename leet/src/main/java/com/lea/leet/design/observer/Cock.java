package com.lea.leet.design.observer;

import java.util.Observable;
import java.util.Observer;

public class Cock implements Observer {

    private Sun sun;

    public Cock(Sun sun) {
        this.sun = sun;
        sun.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Cock gogoda, gogoda..");
    }

    public static void main(String[] args) {
        Sun sun = new Sun();
        Cock cock = new Cock(sun);

        sun.rise();

    }
}


