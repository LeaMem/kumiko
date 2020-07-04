package com.lea.leet.alg;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *      哎，别人的就是别我的效率高而且更优雅
 */
public class Solution636 {


    public static class Task {
        public int id = 0;
        public int time = 0;
        public boolean start = true;

        public Task(String[] split) {
            this.id = Integer.parseInt(split[0]);
            this.time = Integer.parseInt(split[2]);
            this.start = split[1].equals("start");
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Task> stack = new Stack<>();
        int[] ans = new int[n];
        for (String log : logs) {
            Task task = new Task(log.split(":"));
            if (task.start) {
                stack.push(task);
            } else {
                Task last = stack.pop();
                int duration = task.time - last.time + 1;
                ans[task.id] += duration;

                //若栈不为空，说明之前还有任务没有完成，那个任务的执行时间要减去当前任务的执行时间
                if (!stack.isEmpty()) {
                    ans[stack.peek().id] -= duration;
                }
            }
        }
        return ans;
    }


//    public int[] exclusiveTime(int n, List<String> logs) {
//
//        int[] ans = new int[n];
//
//        Pattern pattern = Pattern.compile("(\\d+):(\\w+):(\\d+)");
//
//        LinkedList<Pair> stack = new LinkedList<>();
//
//        for (String str : logs) {
//            Matcher matcher = pattern.matcher(str);
//            if (!matcher.find()) {
//                continue;
//            }
//            int fId = Integer.parseInt(matcher.group(1));
//            String event = matcher.group(2);
//            int time = Integer.parseInt(matcher.group(3));
//
//            if (event.equals("start")) {
//                Pair pair = new Pair(fId, time);
//                stack.push(pair);
//
//            } else if (event.equals("end")) {
//                Pair pop = stack.pop();
//                int exTime = pop.getExTime(time);
//                ans[fId] += exTime;
//
//                for (Pair pair : stack) {
//                    pair.start += exTime;
//                }
//
//            }
//
//        }
//
//        return ans;
//    }
//
//    public static class Pair {
//
//        public int fId;
//        public int start;
//
//
//        public Pair(int fId, int start) {
//            this.fId = fId;
//            this.start = start;
//        }
//
//        public int getExTime(int end) {
//            return end - start + 1;
//        }
//    }

    public static void main(String[] args) {
//        List<String> list = Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7");
//        Solution636 solution636 = new Solution636();
//        int[] ans = solution636.exclusiveTime(2, list);
//        for (int it : ans) {
//            System.out.println(it);
//        }
        Double it = Math.pow(2, 32);
        BigDecimal bigDecimal = BigDecimal.valueOf(it);
        System.out.println(bigDecimal.toString());

    }

}
