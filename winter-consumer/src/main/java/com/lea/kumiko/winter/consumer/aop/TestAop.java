package com.lea.kumiko.winter.consumer.aop;

import com.lea.kumiko.winter.consumer.controller.TestController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *      我总觉的这里是用的责任链模式
 */
@Component
@Aspect
public class TestAop {


    @Pointcut(value = "execution(* com.lea.kumiko.winter.consumer.controller.TestController.current(..))")
    public void currentPointCut(){

    }


    @Around("currentPointCut()")
    @Order(1)
    public Object beforeFirst(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("first");
        return proceedingJoinPoint.proceed(new Object[]{localDateTime});
    }

    @Around("currentPointCut()")
    @Order(2)
    public Object beforeSecond(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Object[] args = proceedingJoinPoint.getArgs();
        System.out.println(args);
        LocalDateTime localDateTime = LocalDateTime.now().minusDays(10);
        System.out.println("second");
        return proceedingJoinPoint.proceed(new Object[]{localDateTime});
    }







}
