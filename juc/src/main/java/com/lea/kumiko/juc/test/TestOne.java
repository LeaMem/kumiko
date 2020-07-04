package com.lea.kumiko.juc.test;

import java.util.HashMap;
import java.util.Map;

public class TestOne {

    public static void main(String[] args) {

        HashMap<String, Object> map = new HashMap<>();
        map.put(null, null);
        System.out.println(map.containsKey(null));
    }

}
