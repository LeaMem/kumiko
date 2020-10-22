package com.lea.kumiko.midware.service;

import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class AbstractService<T> {

	protected Condition getCondition() {

		Class clazz = getClass();

		while (clazz.getSuperclass() != AbstractService.class) {
			clazz = clazz.getSuperclass();
		}

		Class<T> persistentClass = (Class<T>) ((ParameterizedType) clazz
				.getGenericSuperclass())
				.getActualTypeArguments()[0];
		return new Condition(persistentClass);
	}

	protected Condition getConditionV2() {
		Type type = getSuperClassTypeParameter(getClass());
		if (!(type instanceof Class)) {
			throw new RuntimeException("不是泛型类");
		}
		return new Condition((Class<?>) type);
	}

	Type getSuperClassTypeParameter(Class<?> clazz) {
		Type superclass = clazz.getGenericSuperclass();
		if (superclass instanceof Class) {
			//往上找
			if (superclass != AbstractService.class) {
				return getSuperClassTypeParameter(clazz.getSuperclass());
			}
			throw new RuntimeException("泛型定义错误");
		}
		//找到了parameterizedType
		ParameterizedType parameterizedType = (ParameterizedType) superclass;
		Type rawType = parameterizedType.getActualTypeArguments()[0];
		if (rawType instanceof ParameterizedType) {
			rawType = ((ParameterizedType) rawType).getRawType();
		}
		return rawType;
	}

}
