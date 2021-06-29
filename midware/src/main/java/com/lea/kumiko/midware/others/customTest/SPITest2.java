package com.lea.kumiko.midware.others.customTest;

import java.sql.Driver;
import java.util.ServiceLoader;

public class SPITest2 {

    public static void main(String[] args) {
        //Thread.currentThread().setContextClassLoader(ServiceLoaderTest.class.getClassLoader().getParent());
        ServiceLoader<Driver> drivers = ServiceLoader.load(Driver.class);
        for (Driver driver : drivers) {
            System.out.println("driver class:" + driver.getClass().getName() +" || loader:" + driver.getClass().getClassLoader());
        }
        System.out.println("kk");
        System.out.println(SPITest2.class.getClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(ServiceLoader.class.getClassLoader());
    }

}
