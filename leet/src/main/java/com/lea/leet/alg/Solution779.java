package com.lea.leet.alg;

/**
 *      我的超时了
 *      这里要去找规律
 */
public class Solution779 {

    public int kthGrammar(int N, int K) {

        if (N == 1) {
            return 0;
        }

        String s = gen(N - 1, "0");
        System.out.println(s);
        return s.charAt(K - 1) - '0';
    }

    public String gen(int N, String s) {

        if (N == 0) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for (Character ch : s.toCharArray()) {
            if (ch == '0') {
                builder.append("01");
            } else {
                builder.append("10");
            }
        }

        return gen(N - 1, builder.toString());
    }

    public static void main(String[] args) {

        Solution779 solution779 = new Solution779();
        System.out.println(solution779.kthGrammar(2, 1));

    }

}
