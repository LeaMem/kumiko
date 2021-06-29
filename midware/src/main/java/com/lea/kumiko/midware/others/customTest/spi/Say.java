package com.lea.kumiko.midware.others.customTest.spi;

import javax.xml.ws.Service;
import java.util.Iterator;
import java.util.ServiceLoader;

public interface Say {

    void say();

    public static void main(String[] args) {
        ServiceLoader<Say> loader = ServiceLoader.load(Say.class);
        for (Say say : loader) {
            say.say();
        }
    }
}
