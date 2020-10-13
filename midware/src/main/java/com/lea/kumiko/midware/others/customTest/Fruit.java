package com.lea.kumiko.midware.others.customTest;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

public class Fruit {

    private String name;

	public static class Apple extends Fruit {

	}

	public static class Orange extends Fruit {
	    private Integer size;
	}

	public static class Plate<T> {
		T item;

		List<T> list;

		List<? extends Number> list2;


		public T getItem() {
			return item;
		}

		public void setItem(T item) {
			this.item = item;
		}
	}

	public static void main(String[] args) throws NoSuchFieldException {

        Field[] declaredFields1 = Orange.class.getDeclaredFields();


        Field[] declaredFields = Plate.class.getDeclaredFields();
		Field fieldI = Plate.class.getDeclaredField("list2");
		ParameterizedType genericType2 = (ParameterizedType) fieldI.getGenericType();

		for (Type type : genericType2.getActualTypeArguments()) {
			if (type instanceof WildcardType) {
				WildcardType wildcardType = (WildcardType) type;
				String typeName = wildcardType.getTypeName();
				Type[] lowerBounds = wildcardType.getLowerBounds();
				Type[] upperBounds = wildcardType.getUpperBounds();
				System.out.println(upperBounds);
			}
		}

	}


}
