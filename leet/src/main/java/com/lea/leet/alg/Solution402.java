package com.lea.leet.alg;

import java.util.Stack;

/**
 * 关键是要维护一个递增序列，
 * 有点类似于贪心
 */
public class Solution402 {

    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder(num);

        for (int i = 0; i < builder.length(); i++) {

            while (!stack.isEmpty() && stack.peek() > builder.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(builder.charAt(i));
        }

        while (k > 0) {
            k--;
            stack.pop();
        }

        while (stack.size() > 0 && stack.get(0) == '0') {
            stack.remove(0);
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            ans.append(stack.get(i));
        }

        return ans.length() > 0 ? ans.toString() : "0";
    }

    public static void main(String[] args) {

        String it = "1234567890";
        Solution402 solution402 = new Solution402();
        String ans = solution402.removeKdigits(it, 9);
        System.out.println(ans);

    }

}
