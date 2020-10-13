package com.lea.kumiko.midware.others.reflection;

import java.lang.reflect.*;

public class TypeParameterResolver {

    public static Type resolveFieldType(Field field, Type srcType) {
        Type fieldType = field.getGenericType();
        Class<?> declaringClass = field.getDeclaringClass();

    }


    private static Type resolveType(Type type, Type srcType, Class<?> declaringClass) {
        //T
        if (type instanceof TypeVariable) {

        } else if (type instanceof ParameterizedType) {
            //List<String>

        } else if (type instanceof GenericArrayType) {
            //

        } else {

        }
    }

}
