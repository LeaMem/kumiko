package com.lea.leet.alg;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution1190 {

    public String reverseParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        int[] pair = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                Integer j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuilder builder = new StringBuilder();

        //好神奇的哟
        for (int i = 0, d = 1; i < s.length(); i += d) {

            if (s.charAt(i) == '(' || s.charAt(i) == ')') {

                i = pair[i];
                d = -d;

            } else {
                builder.append(s.charAt(i));
            }

        }

        return builder.toString();
    }

//    public String reverseParentheses(String s) {
//
//        Stack<Character> stack = new Stack<>();
//
//        for (Character ch : s.toCharArray()) {
//
//            if (ch == ')') {
//
//                List<Character> list = new LinkedList<>();
//                while (!stack.isEmpty() && !stack.peek().equals('(')) {
//                    list.add(stack.pop());
//                }
//
//                if (!stack.isEmpty() && stack.peek() == '(') {
//                    stack.pop();
//                }
//
//                for (Character c : list) {
//                    stack.push(c);
//                }
//
//
//            } else {
//                stack.push(ch);
//            }
//        }
//
//        StringBuilder builder = new StringBuilder();
//        while (!stack.isEmpty()) {
//            builder.append(stack.pop());
//        }
//
//
//        return builder.reverse().toString();
//    }

    public static void main(String[] args) {

        Solution1190 solution1190 = new Solution1190();
        String s = solution1190.reverseParentheses("a(bcdefghijkl(mno)p)q");
        System.out.println(s);

    }

}
