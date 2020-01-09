package com.lea.leet.alg;

import java.util.Arrays;
import java.util.Comparator;

public class Solution14 {

    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0){
            return "";
        }

        String minOne = Arrays.stream(strs)
                .min(Comparator.comparing(String::length))
                .get();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < minOne.length(); i++) {

            boolean eq = true;
            for (String str : strs) {
                if (str.charAt(i) != minOne.charAt(i)) {
                    eq = false;
                    break;
                }
            }

            if (eq) {
                builder.append(minOne.charAt(i));
            } else {
                break;
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        String first = "kittyding";
        String second = "sdfkittyding1";
        System.out.println(second.indexOf(first));
    }

}
