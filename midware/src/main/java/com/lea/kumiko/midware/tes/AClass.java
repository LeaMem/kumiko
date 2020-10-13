package com.lea.kumiko.midware.tes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AClass extends AbstractT implements AInterface<String>{
	@Override
	public void func(String s) {
		System.out.println(s);
	}

	public static void addUniqueMethods(Map<String, Method> uniqueMethods, Method[] methods) {
		for (Method currentMethod : methods) {
			if (!currentMethod.isBridge()) {
				String signature = getSignature(currentMethod);
				// check to see if the method is already known
				// if it is known, then an extended class must have
				// overridden a method
				if (!uniqueMethods.containsKey(signature)) {
					uniqueMethods.put(signature, currentMethod);
				}
			}
		}
	}

	public static Method[] getClassMethods(Class<?> clazz) {
		Map<String, Method> uniqueMethods = new HashMap<>();
		Class<?> currentClass = clazz;
		while (currentClass != null && currentClass != Object.class) {
			addUniqueMethods(uniqueMethods, currentClass.getDeclaredMethods());

			// we also need to look for interface methods -
			// because the class may be abstract
			Class<?>[] interfaces = currentClass.getInterfaces();
			for (Class<?> anInterface : interfaces) {
				addUniqueMethods(uniqueMethods, anInterface.getMethods());
			}

			currentClass = currentClass.getSuperclass();
		}

		Collection<Method> methods = uniqueMethods.values();

		return methods.toArray(new Method[0]);
	}

	public static String getSignature(Method method) {
		StringBuilder sb = new StringBuilder();
		Class<?> returnType = method.getReturnType();
		if (returnType != null) {
			sb.append(returnType.getName()).append('#');
		}
		sb.append(method.getName());
		Class<?>[] parameters = method.getParameterTypes();
		for (int i = 0; i < parameters.length; i++) {
			sb.append(i == 0 ? ':' : ',').append(parameters[i].getName());
		}
		return sb.toString();
	}

	public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

		Method[] classMethods = getClassMethods(AClass.class);
		for (int i = 0; i < classMethods.length; i++) {
			System.out.println(classMethods[i].getName());
		}

	}

	@Override
	String sayHello(String name) {
		return name;
	}
}
