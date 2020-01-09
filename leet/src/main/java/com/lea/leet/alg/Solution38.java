package com.lea.leet.alg;

public class Solution38 {

    public String countAndSay(int n) {

        String init = "1";

        for (int i = 2; i <= n; i++) {
            init = traverseIt(init);
        }

        return init;
    }

    private String traverseIt(String str) {

        if (str.equals("1")) {
            return "11";
        }

        StringBuilder builder = new StringBuilder();

        int cnt = 1;

        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i) != str.charAt(i - 1)) {
                builder.append(cnt).append(str.charAt(i - 1));
                if (i == str.length() - 1) {
                    builder.append(1).append(str.charAt(i));
                }
                cnt = 1;
            } else {
                cnt++;
                if (i == str.length() - 1) {
                    builder.append(cnt).append(str.charAt(i));
                }
            }

        }
        return builder.toString();
    }

    public static void main(String[] args) {

        System.out.println(new Solution38().countAndSay(6));

    }
}
