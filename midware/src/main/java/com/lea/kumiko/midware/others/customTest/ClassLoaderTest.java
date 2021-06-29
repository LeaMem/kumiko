package com.lea.kumiko.midware.others.customTest;

public class ClassLoaderTest  extends ClassLoader{

    public static void main(String[] args) {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        ClassLoader parent = classLoaderTest.getParent();
        while(parent != null){
            System.out.println(parent);
            parent = parent.getParent();
        }
    }
}
