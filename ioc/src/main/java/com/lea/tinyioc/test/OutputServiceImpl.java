package com.lea.tinyioc.test;

public class OutputServiceImpl implements OutputService{

    @Override
    public void output(String text) {
        System.out.println(text);
    }
}
