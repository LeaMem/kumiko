package com.lea.tinyioc.aop;


import com.lea.tinyioc.HelloWorldService;
import org.junit.Assert;
import org.junit.Test;

public class AspectJExpressionPointcutTest {


    @Test
    public void testClassFilter() {
        String expression = "execution(* com.lea.tinyioc.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloWorldService.class);
        Assert.assertTrue(matches);
    }

    @Test
    public void testMethodInterceptor() throws NoSuchMethodException {

        String expression = "execution(* com.lea.tinyioc.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);

        boolean matches = aspectJExpressionPointcut.getMethodMatcher()
                .matches(HelloWorldService.class.getMethod("helloWorld"), HelloWorldService.class);

        Assert.assertTrue(matches);
    }

}
