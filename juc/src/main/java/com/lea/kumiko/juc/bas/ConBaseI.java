package com.lea.kumiko.juc.bas;

import com.sun.xml.internal.rngom.parse.host.Base;
import org.apache.ibatis.reflection.Reflector;
import org.apache.ibatis.reflection.invoker.Invoker;
import sun.font.CreatedFontTracker;

import java.lang.reflect.InvocationTargetException;

public class ConBaseI extends BaseI<String> {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        String format = String.format("%-10s\t %-10s\t %-50s\t %-10s\t", "tst1", "sfskksdfsdfsdfsdf", "sdfksj", "tstwwer");
        String format2 = String.format("%-10s\t %-10s\t %-50s\t %-10s\t", "dfsdfsdfsdf", "sfskksdfsdfsdfsdf", "sdfsdfsdfsdfsdfadf", "tstwwer");

        System.out.println(format);
        System.out.println(format2);

    }
}
