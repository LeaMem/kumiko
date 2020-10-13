package com.lea.kumiko.midware.others.reflection.factory;

import java.util.List;
import java.util.Properties;

public interface ObjectFactory {

	default void setProperties(Properties properties){

	}

	/**
	 *      通过默认构造器创建对象
	 * @param type
	 * @param <T>
	 * @return
	 */
	<T> T create(Class<T> type);

	<T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs);

	<T> boolean isCollection(Class<T> type);
}
