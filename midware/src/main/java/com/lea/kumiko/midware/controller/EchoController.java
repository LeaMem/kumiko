package com.lea.kumiko.midware.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class EchoController {

    static {
        System.out.println("hello world");
    }

    public EchoController() {

    }

    @RequestMapping(value = "/{pt:h5pt|pt}/echo")
    public String echo(String str){
        return "echo: " + str;
    }

    public static void main(String[] args) {
        int[] a  = new int[10];
        System.out.println();
        Object instance = Array.newInstance(Integer.class, 10);
        System.out.println(instance.getClass());
    }

}
