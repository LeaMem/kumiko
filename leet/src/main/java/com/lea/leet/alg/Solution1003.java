package com.lea.leet.alg;

public class Solution1003 {

//    public boolean isValid(String S) {
//        StringBuilder builder = new StringBuilder(S);
//
//        while(builder.length() > 0){
//            int find = builder.indexOf("abc");
//            if(find < 0){
//                break;
//            }
//            builder.replace(find, find + 3, "");
//        }
//
//        return builder.length() == 0;
//    }

    public boolean isValid(String S) {

        char[] chars = S.toCharArray();
        char[] stack = new char[S.length()];

        int index = 0;
        for (int i = 0; i < S.length(); i++) {
            if (chars[i] != 'c') {
                stack[index++] = chars[i];
            } else {
                if (index <= 1) {
                    return false;
                }
                if (stack[index - 1] == 'b' && stack[index - 2] == 'a') {
                    index -= 2;
                }
            }
        }

        return index == 0;
    }

    public static void main(String[] args) {
        String str = "abccba";
        Solution1003 solution1003 = new Solution1003();
        boolean bool = solution1003.isValid(str);
        System.out.println(bool);
    }

}
