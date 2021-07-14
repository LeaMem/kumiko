package com.lea.kumiko.midware.tes;

import java.util.Iterator;
import java.util.ServiceLoader;

public interface Say {

    void say();

    public static void main(String[] args) {
        ServiceLoader<Say> serviceLoader = ServiceLoader.load(Say.class);

        for (int i = 0; i < 3; i++) {
            Iterator<Say> iterator = serviceLoader.iterator();
            while(iterator.hasNext()){
                Say next = iterator.next();
                next.say();
            }
        }
    }
}
