package com.lea.kumiko.midware.others.reflection.property;

import com.lea.kumiko.midware.others.reflection.Reflector;

import java.lang.reflect.Field;

public class PropertyCopier {

    private PropertyCopier() {

    }

    public static void copyBeanProperties(Class<?> type, Object sourceBean, Object destinationBean) {
        Class<?> parent = type;
        while (parent != null) {
            Field[] declaredFields = parent.getDeclaredFields();
            for (Field field : declaredFields) {
                try {
                    try {
                        field.set(destinationBean, field.get(sourceBean));
                    } catch (IllegalAccessException e) {
                        if (Reflector.canControlMemberAccessible()) {
                            field.setAccessible(true);
                            field.set(destinationBean, field.get(sourceBean));
                        } else {
                            throw e;
                        }
                    }
                } catch (Exception e) {

                }
            }
            parent = parent.getSuperclass();
        }
    }

}
