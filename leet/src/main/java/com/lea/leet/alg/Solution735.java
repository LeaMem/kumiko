package com.lea.leet.alg;

import java.util.LinkedList;

public class Solution735 {

    public int[] asteroidCollision(int[] asteroids) {

        LinkedList<Integer> stack = new LinkedList<>();

        for (int it : asteroids) {

            if (stack.isEmpty() || !(stack.peek() > 0 && it < 0)) {
                stack.push(it);
            }

            while (!stack.isEmpty() && stack.peek() > 0 && it < 0) {
                int last = stack.poll();
                if (last > Math.abs(it)) {
                    stack.push(last);
                    break;
                } else if (last == Math.abs(it)) {
                    break;
                } else {
                    if (stack.isEmpty() || stack.peek() < 0) {
                        stack.push(it);
                        break;
                    }
                }
            }

        }

        int[] ans = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.poll();
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {10, 2, -5};
        Solution735 solution735 = new Solution735();
        int[] ans = solution735.asteroidCollision(nums);
        for (int it : ans) {
            System.out.println(it);
        }

    }

}
