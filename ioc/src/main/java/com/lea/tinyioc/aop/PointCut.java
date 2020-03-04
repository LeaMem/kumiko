package com.lea.tinyioc.aop;

public interface PointCut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
