package com.lea.kumiko.midware.service;

import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.ParameterizedType;

public class AbstractService<T> {

    protected Condition getCondition(){

        Class clazz = getClass();

        while(clazz.getSuperclass() != AbstractService.class){
            clazz = clazz.getSuperclass();
        }

        Class<T> persistentClass = (Class<T>) ((ParameterizedType) clazz
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
        return new Condition(persistentClass);
    }

}
