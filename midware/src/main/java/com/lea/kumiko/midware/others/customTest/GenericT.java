package com.lea.kumiko.midware.others.customTest;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

public class GenericT<T, K, M> {

	public static class SubGeneric<T, K> extends GenericT<T, K, String>{

	}

	public static class SKGeneric extends SubGeneric<Long, Integer>{

	}


	public static void main(String[] args) {



		Class<String[]> aClass = String[].class;
		Class<?> aClass1 = Array.newInstance(String.class, 0).getClass();
		System.out.println(aClass1 == aClass);
		System.out.println(aClass);

		TypeVariable<?>[] typeParameters = SKGeneric.class.getTypeParameters();

		//srcType
		Type subGeneric = SKGeneric.class.getGenericSuperclass();
		ParameterizedType srcType = (ParameterizedType) subGeneric;

		//srcClass
		Class<?> srcClass = (Class<?>) srcType.getRawType();

		//parentType
		ParameterizedType parentType = (ParameterizedType) (srcClass.getGenericSuperclass());

		//parentTypeArgs
		Type[] parentTypeArgs = parentType.getActualTypeArguments();
		Type[] srcTypeArgs = srcType.getActualTypeArguments();
		TypeVariable<?>[] srcTypeVars = srcClass.getTypeParameters();


		System.out.println(parentType);
	}

}
