package com.lea.kumiko.juc.bas;


import org.apache.ibatis.reflection.TypeParameterResolver;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.*;

public class ITA<T extends List & Iterable> {

    List<T[]> list = new ArrayList<>();


    void add(Collection<? extends T> collection) {
        System.out.println(collection.size());
    }

    public static void main(String[] args) throws NoSuchFieldException {

        TypeVariable<Class<ITA>>[] typeParameters = ITA.class.getTypeParameters();
        for (int i = 0; i < typeParameters.length; i++) {
            TypeVariable<Class<ITA>> typeParameter = typeParameters[i];
            typeParameter.getGenericDeclaration();
            if(typeParameter instanceof TypeVariable){
                TypeVariable typeVariable = typeParameter;
                Type[] bounds = typeVariable.getBounds();
                System.out.println(bounds);
            }
            System.out.println(typeParameters[i]);
        }

    }

}
