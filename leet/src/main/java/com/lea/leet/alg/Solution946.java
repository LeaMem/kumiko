package com.lea.leet.alg;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * 这里看的是别人的解法
 */
public class Solution946 {

    /**
     *          数组直接当成栈使，真的厉害
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int size = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            pushed[size++] = pushed[i];
            while (size != 0 && pushed[size - 1] == popped[j]) {
                size--;
                j++;
            }
        }
        return j == n;
    }

//    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        if (pushed.length != popped.length) {
//            return false;
//        }
//
//        LinkedList<Integer> stack = new LinkedList<>();
//
//        LinkedList<Integer> queue = Arrays.stream(popped)
//                .boxed()
//                .collect(Collectors.toCollection(LinkedList::new));
//
//        for (int it : pushed) {
//            stack.push(it);
//            while (!queue.isEmpty() && queue.peek().equals(stack.peek())) {
//                stack.pop();
//                queue.poll();
//            }
//        }
//
//        return stack.isEmpty();
//    }


    public static void main(String[] args) {

        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};

        Solution946 solution = new Solution946();

        boolean result = solution.validateStackSequences(pushed, popped);

        System.out.println(result);

    }

}
