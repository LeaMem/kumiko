package com.lea.kumiko.midware.others.customTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

public abstract class AbsT implements Runnable{

    private String ding;

    public abstract List<Integer> getName();

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        Method[] declaredMethods = AbsT.class.getDeclaredMethods();
        Method getName = AbsT.class.getMethod("getName");
        Type returnType = getName.getGenericReturnType();
        Field ding = AbsT.class.getDeclaredField("ding");
        Class<?> declaringClass = ding.getDeclaringClass();
        System.out.println(declaringClass);
    }

}
