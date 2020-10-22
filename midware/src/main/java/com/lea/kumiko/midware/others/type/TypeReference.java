package com.lea.kumiko.midware.others.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class TypeReference<T> {

	private final Type rawType;

	protected TypeReference(){
		this.rawType = getSuperClassTypeParameter(getClass());
	}

	Type getSuperClassTypeParameter(Class<?> clazz){
		Type superclass = clazz.getGenericSuperclass();
		if(superclass instanceof Class){
			//继续往上找
			if(TypeReference.class != superclass){
				return getSuperClassTypeParameter(clazz.getSuperclass());
			}

			throw new RuntimeException("misses type parameter");
		}

		Type rawType = ((ParameterizedType) superclass).getActualTypeArguments()[0];

		if(rawType instanceof ParameterizedType){
			rawType = ((ParameterizedType) rawType).getRawType();
		}

		return rawType;
	}

}
