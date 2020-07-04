package com.lea.leet.alg;


import java.util.Arrays;
import java.util.Stack;

/**
 * 看大神的操作
 */
public class Solution1249 {

    public String minRemoveToMakeValid(String s) {

        boolean[] valid = new boolean[s.length()];
        Arrays.fill(valid, true);

        Stack<Integer> stack = new Stack<>();

        /**
         *      找到哪里不正确
         */
        for (int i = 0; i < s.length(); i++) {
            char it = s.charAt(i);
            if (it == '(') {
                stack.push(i);
                valid[i] = false;
            } else if (it == ')') {
                if (stack.isEmpty()) {
                    valid[i] = false;
                } else {
                    valid[i] = true;
                    Integer index = stack.pop();
                    valid[index] = true;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < valid.length; i++) {
            if (valid[i]) {
                builder.append(s.charAt(i));
            }
        }


        return builder.toString();

    }

    public static void main(String[] args) {



    }

}
