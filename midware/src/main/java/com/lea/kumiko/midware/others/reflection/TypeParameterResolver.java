package com.lea.kumiko.midware.others.reflection;

import java.lang.reflect.*;

public class TypeParameterResolver {

	private TypeParameterResolver() {

	}

	public static Type resolveFieldType(Field field, Type srcType) {
		Type fieldType = field.getGenericType();
		Class<?> declaringClass = field.getDeclaringClass();

		return null;
	}


	private static Type resolveType(Type type, Type srcType, Class<?> declaringClass) {
		//T
		if (type instanceof TypeVariable) {

		} else if (type instanceof ParameterizedType) {
			//List<String>

		} else if (type instanceof GenericArrayType) {
			//

		} else {
			//class
			return type;
		}
		return null;
	}

	private static Type resolveTypeVar(TypeVariable<?> typeVar, Type srcType, Class<?> declaringClass) {
		Type result;
		Class<?> clazz;

		//找到正确的 clazz
		if (srcType instanceof Class) {
			clazz = (Class<?>) srcType;
		} else if (srcType instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) srcType;
			clazz = (Class<?>) parameterizedType.getRawType();
		} else {
			throw new IllegalArgumentException("2nd args incorrect");
		}

		//已经到了变量申明的一层了
		if (clazz == declaringClass) {
			Type[] bounds = typeVar.getBounds();
			if (bounds.length > 0) {
				return bounds[0];
			}
			return Object.class;
		}

		//泛型类
		Type superclass = clazz.getGenericSuperclass();
		result = scanSuperTypes(typeVar, srcType, declaringClass, clazz, superclass);
		if(result != null){
			return result;
		}

		Type[] superInterfaces = clazz.getGenericInterfaces();
		for(Type superInterface : superInterfaces){
			result = scanSuperTypes(typeVar, srcType, declaringClass, clazz, superInterface);
			if(result != null){
				return result;
			}
		}

		return Object.class;
	}

	/**
	 * @param typeVar        typeVariable
	 * @param srcType        类
	 * @param declaringClass 声明字段的类
	 * @param clazz          当前遍历的类
	 * @param superclass     当前遍历的类的父类
	 * @return
	 */
	private static Type scanSuperTypes(TypeVariable<?> typeVar, Type srcType, Class<?> declaringClass, Class<?> clazz, Type superclass) {
		if (superclass instanceof ParameterizedType) {
			ParameterizedType parentAsType = (ParameterizedType) superclass;
			Class<?> parentAsClass = (Class<?>) parentAsType.getRawType();
			TypeVariable<?>[] parentTypeVars = parentAsClass.getTypeParameters();
			if (srcType instanceof ParameterizedType) {
				//通过这个保存泛型变量信息
				parentAsType = translateParentTypeVars((ParameterizedType) srcType, clazz, parentAsType);
			}
			if (declaringClass == parentAsClass) {
				for (int i = 0; i < parentTypeVars.length; i++) {
					if(typeVar.equals(parentTypeVars[i])){
						return parentAsType.getActualTypeArguments()[i];
					}
				}
			}
			if(declaringClass.isAssignableFrom(parentAsClass)){
				return resolveTypeVar(typeVar, parentAsType, declaringClass);
			}
		} else if (superclass instanceof Class && declaringClass.isAssignableFrom((Class<?>) superclass)) {
			return resolveTypeVar(typeVar, superclass, declaringClass);
		}
		return null;
	}

	/**
	 * 参考 GenericT
	 *
	 * @param srcType
	 * @param srcClass
	 * @param parentType
	 * @return
	 */
	private static ParameterizedType translateParentTypeVars(ParameterizedType srcType, Class<?> srcClass, ParameterizedType parentType) {

		Type[] parentTypeArgs = parentType.getActualTypeArguments();
		Type[] srcTypeArgs = srcType.getActualTypeArguments();
		TypeVariable<?>[] srcTypeVars = srcClass.getTypeParameters();

		Type[] newParentArgs = new Type[parentTypeArgs.length];
		boolean noChange = true;
		for (int i = 0; i < parentTypeArgs.length; i++) {
			if (parentTypeArgs[i] instanceof TypeVariable) {
				for (int j = 0; j < srcTypeVars.length; j++) {
					if (srcTypeVars[j].equals(parentTypeArgs[i])) {
						noChange = false;
						newParentArgs[i] = srcTypeArgs[j];
					}
				}
			} else {
				newParentArgs[i] = parentTypeArgs[i];
			}
		}
		return noChange ? parentType : new ParameterizedTypeImpl((Class<?>) parentType.getRawType(), null, newParentArgs);
	}

	static class ParameterizedTypeImpl implements ParameterizedType {
		private Class<?> rawType;
		private Type ownerType;
		private Type[] actualTypeArguments;

		public ParameterizedTypeImpl(Class<?> rawType, Type ownerType, Type[] actualTypeArguments) {
			this.rawType = rawType;
			this.ownerType = ownerType;
			this.actualTypeArguments = actualTypeArguments;
		}

		@Override
		public Type[] getActualTypeArguments() {
			return actualTypeArguments;
		}

		@Override
		public Type getRawType() {
			return rawType;
		}

		@Override
		public Type getOwnerType() {
			return ownerType;
		}
	}

	static class WildcardTypeImpl implements WildcardType {

		private Type[] lowerBounds;

		private Type[] upperBounds;

		public WildcardTypeImpl(Type[] lowerBounds, Type[] upperBounds) {
			super();
			this.lowerBounds = lowerBounds;
			this.upperBounds = upperBounds;
		}

		@Override
		public Type[] getUpperBounds() {
			return lowerBounds;
		}

		@Override
		public Type[] getLowerBounds() {
			return upperBounds;
		}
	}

	static class GenericArrayTypeImpl implements GenericArrayType {

		private Type genericComponentType;

		public GenericArrayTypeImpl(Type genericComponentType) {
			super();
			this.genericComponentType = genericComponentType;
		}

		@Override
		public Type getGenericComponentType() {
			return genericComponentType;
		}
	}

}
