package com.lea.kumiko.midware.others.reflection.factory;

import com.lea.kumiko.midware.others.reflection.Reflector;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class DefaultObjectFactory implements ObjectFactory, Serializable {

	/**
	 * 通过默认构造器创建对象
	 *
	 * @param type
	 * @return
	 */
	@Override
	public <T> T create(Class<T> type) {
		return create(type, null, null);
	}

	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		Class<?> classToCreate = resolveInterface(type);
		return instantiateClass(type, constructorArgTypes, constructorArgs);
	}

	@Override
	public <T> boolean isCollection(Class<T> type) {
	    return Collection.class.isAssignableFrom(type);
	}

	protected Class<?> resolveInterface(Class<?> type) {
		Class<?> classToCreate;
		if (type == List.class || type == Collection.class || type == Iterable.class) {
			classToCreate = ArrayList.class;
		} else if (type == Map.class) {
			classToCreate = HashMap.class;
		} else if (type == SortedMap.class) {
			classToCreate = TreeSet.class;
		} else if (type == Set.class) {
			classToCreate = HashSet.class;
		} else {
			classToCreate = type;
		}
		return classToCreate;
	}

    /**
     *      通过构造器初始化对象
     * @param type
     * @param constructorArgTypes
     * @param constructorArgs
     * @param <T>
     * @return
     */
	private <T> T instantiateClass(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		try {
			Constructor<T> constructor = null;
			if (constructorArgTypes == null || constructorArgs == null) {
				constructor = type.getDeclaredConstructor();
				try {
					return constructor.newInstance();
				} catch (IllegalAccessException e) {
					if (Reflector.canControlMemberAccessible()) {
						constructor.setAccessible(true);
						return constructor.newInstance();
					} else {
						throw e;
					}
				}
			}
			constructor = type.getDeclaredConstructor(constructorArgTypes.toArray(new Class[0]));
			try{
			    return constructor.newInstance(constructorArgs.toArray(new Object[0]));
            }catch (IllegalAccessException e){
			    if(Reflector.canControlMemberAccessible()){
			        constructor.setAccessible(true);
			        return constructor.newInstance(constructorArgs.toArray(new Object[0]));
                }else{
			        throw e;
                }
            }
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("constructor error");
		}
	}
}
