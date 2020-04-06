package com.lea.leet.alg;

import java.util.Deque;
import java.util.LinkedList;

public class Solution921 {

    public int minAddToMakeValid(String S) {

        Deque<Character> stack = new LinkedList<>();

        for (Character ch : S.toCharArray()) {

            if (ch.equals('(')) {
                stack.push(ch);
            } else if (ch.equals(')')) {
                if (!stack.isEmpty() && stack.peek().equals('(')) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        return stack.size();

    }

    public static void main(String[] args) {

        String str = "())";
        int result = new Solution921().minAddToMakeValid(str);
        System.out.println(result);

    }

}
