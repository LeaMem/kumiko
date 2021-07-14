package com.lea.kumiko.juc.test;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class Main14 {

    public static void main(String[] args) throws Exception {
        Class<Supper> subClass = Supper.class;
        TypeVariable<Class<Supper>>[] typeParameters = subClass.getTypeParameters();

        for (TypeVariable<Class<Supper>> typeVariable : typeParameters) {
            System.out.println("getBounds --> " + Arrays.toString(typeVariable.getBounds()));
            System.out.println("getGenericDeclaration  --> " + typeVariable.getGenericDeclaration());
            System.out.println("getName --> " + typeVariable.getName());
            AnnotatedType[] annotatedBounds = typeVariable.getAnnotatedBounds();
            for (AnnotatedType annotatedBound : annotatedBounds) {
                System.out.println(annotatedBound.getType());
            }

            System.out.println("===================");

            new Supper<Person, Person>();
        }
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Annotationk {

    }

    interface InterFace {

    }

    @Custom
    public static class Person {

    }

    public static class Supper<T extends Person,D extends Object> {

    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Custom {
    }




}