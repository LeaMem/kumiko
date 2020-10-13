package com.lea.kumiko.midware.others.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParamNameUtil {

    private ParamNameUtil() {

    }

    public static List<String> getParamNames(Method method) {
        return getParameterNames(method);
    }

    private static List<String> getParamNames(Constructor<?> constructor) {
        return getParameterNames(constructor);
    }

    private static List<String> getParameterNames(Executable executable) {
        return Arrays.stream(executable.getParameters()).map(Parameter::getName).collect(Collectors.toList());
    }

}
