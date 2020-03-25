package com.lea.leet.alg;


import java.util.LinkedList;

public class Solution394_2 {

    public String decodeString(String s) {

        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<String> strStack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + ch - '0';
            } else if ((ch <= 'z' && ch >= 'a') || (ch <= 'Z' && ch >= 'A')) {
                sb.append(ch);
            } else if (ch == '[') {

                numStack.push(num);
                num = 0;
                strStack.push(sb.toString());
                sb = new StringBuilder();

            } else {

                //ch == ']'
                StringBuilder tmp = new StringBuilder(strStack.pop());
                int times = numStack.pop();
                for (int j = 0; j < times; j++) {
                    tmp.append(sb);
                }

                sb = tmp;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "3[a]2[b4[F]c]";
        Solution394_2 solution394_2 = new Solution394_2();

        System.out.println(solution394_2.decodeString(str));
    }

}
