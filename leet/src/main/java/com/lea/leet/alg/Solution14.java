package com.lea.leet.alg;

import java.util.Arrays;
import java.util.Comparator;

public class Solution14 {


    public String longestCommonPrefix(String[] strs){
        if(strs.length == 0){
            return "";
        }
        String str = strs[0];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++){

            boolean flag = true;
            for (int j = 1; j < strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != str.charAt(i)){
                    flag = false;
                    break;
                }
            }

            if(flag){
                builder.append(str.charAt(i));
            }else{
                break;
            }
        }
        return builder.toString();
    }

//    public String longestCommonPrefix(String[] strs) {
//
//        if(strs.length == 0){
//            return "";
//        }
//
//        String minOne = Arrays.stream(strs)
//                .min(Comparator.comparing(String::length))
//                .get();
//
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < minOne.length(); i++) {
//
//            boolean eq = true;
//            for (String str : strs) {
//                if (str.charAt(i) != minOne.charAt(i)) {
//                    eq = false;
//                    break;
//                }
//            }
//
//            if (eq) {
//                builder.append(minOne.charAt(i));
//            } else {
//                break;
//            }
//        }

//        return builder.toString();
//    }

    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        String s = solution14.longestCommonPrefix(new String[]{"ab", "a"});
        System.out.println(s);
    }

}
