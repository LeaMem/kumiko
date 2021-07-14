package com.lea.kumiko.juc.test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyKite extends ArrayList<String> {

    private Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws NoSuchFieldException {
        Type genericSuperclass = MyKite.class.getGenericSuperclass();
        if(genericSuperclass instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            System.out.println(parameterizedType.getTypeName());


            Type rawType = parameterizedType.getRawType();
            System.out.println(rawType);

            Type ownerType = parameterizedType.getOwnerType();
            System.out.println(ownerType);
        }
    }
}
