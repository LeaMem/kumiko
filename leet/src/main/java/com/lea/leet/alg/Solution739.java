package com.lea.leet.alg;

import java.util.LinkedList;

/**
 *      我擦，刚才看到一个大佬的思路是这样的：
 *          从后往前遍历，用类似插入排序的方式
 */
public class Solution739 {

    public int[] dailyTemperatures(int[] T) {

        LinkedList<TemperatureDay> stack = new LinkedList<>();

        int[] result = new int[T.length];

        for (int i = 0; i < T.length; i++) {

            int it = T[i];

            if (!stack.isEmpty() && stack.peek().temperature <= it) {

                while (!stack.isEmpty() && stack.peek().temperature < it) {
                    TemperatureDay temperatureDay = stack.pop();
                    result[temperatureDay.day] = i - temperatureDay.day;
                }

            }
            stack.push(new TemperatureDay(i, it));
        }


        return result;
    }


    public static class TemperatureDay {
        public int day;
        public int temperature;

        public TemperatureDay(int day, int temperature) {
            this.day = day;
            this.temperature = temperature;
        }
    }

    public static void main(String[] args) {
        int[] day = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        Solution739 solution739 = new Solution739();
        int[] res = solution739.dailyTemperatures(day);
        for (int it : res) {
            System.out.println(it);
        }
    }

}
