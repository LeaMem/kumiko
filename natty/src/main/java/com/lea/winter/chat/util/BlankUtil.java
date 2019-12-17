package com.lea.winter.chat.util;

public class BlankUtil {

    public static boolean isBlack(final String str){
        return (str == null) || (str.trim().length()) <= 0;
    }

}
