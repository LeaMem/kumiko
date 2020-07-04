package com.lea.leet.alg;

import java.util.Stack;

/**
 *      这里的栈我也用的不行
 *
 */
public class StockSpanner {

    private Stack<Pair> stack;

    public StockSpanner() {
        this.stack = new Stack<>();

    }

    public int next(int price) {

        int day = 1;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            Pair pop = stack.pop();
            day += pop.day;
        }

        stack.push(new Pair(price, day));
        return day;
    }

    public static class Pair {
        public int price;
        public int day;

        public Pair(int price, int day) {
            this.price = price;
            this.day = day;
        }
    }

    public static void main(String[] args) {
        StockSpanner S = new StockSpanner();
        int ans;
        ans = S.next(31);
        System.out.println(ans);
        ans = S.next(41);
        System.out.println(ans);
        ans = S.next(48);
        System.out.println(ans);
        ans = S.next(59);
        System.out.println(ans);
        ans = S.next(79);
        System.out.println(ans);


    }


}
