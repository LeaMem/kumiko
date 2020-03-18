package com.lea.leet.alg;

import java.util.LinkedList;

public class Solution394 {

    public String decodeString(String s) {

        LinkedList<String> stack = new LinkedList<>();

        for (Character ch : s.toCharArray()) {

            if (ch == ']') {
                String str = create(stack);
                stack.push(str);
            } else {
                stack.push(String.valueOf(ch));
            }

        }

        StringBuilder res = new StringBuilder();

        while (!stack.isEmpty()) {
            String it = stack.pop();
            res.insert(0, it);
        }

        return res.toString();
    }


    public String create(LinkedList<String> stack) {

        if (stack.isEmpty()) {
            return "";
        }

        StringBuilder it = new StringBuilder();
        while (!stack.isEmpty() && !stack.peek().equals("[")) {
            String tmp = stack.pop();
            it.insert(0, tmp);
        }

        if (!stack.isEmpty() && stack.peek().equals("[")) {
            stack.pop();
        }

        StringBuilder res = new StringBuilder();

        //拼接数字
        StringBuilder nu = new StringBuilder();
        while (!stack.isEmpty() && stack.peek().matches("\\d")) {
            nu.insert(0, stack.pop());
        }

        if (nu.capacity() > 0) {

            Integer multi = Integer.valueOf(nu.toString());
            for (int i = 0; i < multi; i++) {
                res.append(it.toString());
            }
        } else {
            res.append(it.toString());
        }


        return res.toString();
    }


    public static void main(String[] args) {

        String it = "3[a2[cr]]";

        String f1 = "zzzyypqfejkjkfejkjkfejkjkfejkjkyypqfejkjkfejkjkfejkjkfejkjkef";
        String f2 = "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef";

        Solution394 solution394 = new Solution394();

        String res = solution394.decodeString(it);

        System.out.println(res);
    }


}
