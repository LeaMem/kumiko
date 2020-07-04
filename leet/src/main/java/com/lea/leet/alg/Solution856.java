package com.lea.leet.alg;

import java.util.Stack;

public class Solution856 {

    public int scoreOfParentheses(String S) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (ch == '(') {
                stack.push(0);
            } else {

                if (stack.peek() == 0) {
                    stack.pop();
                    stack.push(1);
                } else {

                    int tmp = 0;
                    while (stack.peek() != 0) {
                        tmp += stack.pop();
                    }
                    stack.pop();
                    stack.push(2 * tmp);
                }

            }

        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    public static void main(String[] args) {

        Solution856 solution856 = new Solution856();
        int ans = solution856.scoreOfParentheses("(()(()))");
        System.out.println(ans);
    }

}
