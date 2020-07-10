package com.lea.leet.alg;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution150 {

    public int evalRPN(String[] tokens) {

        LinkedList<String> stack = new LinkedList<>();

        for (String str : tokens){
            if(str.matches("-?\\d+")){
                stack.push(str);
            }else{
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                switch (str) {
                    case "+":
                        stack.push(first + second + "");
                        break;
                    case "-":
                        stack.push(first - second + "");
                        break;
                    case "*":
                        stack.push(first * second + "");
                        break;
                    case "/":
                        stack.push(first / second + "");
                        break;
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {

        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        Solution150 solution150 = new Solution150();
        int result = solution150.evalRPN(tokens);
        System.out.println(result);

    }

}
