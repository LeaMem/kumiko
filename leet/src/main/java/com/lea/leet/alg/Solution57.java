package com.lea.leet.alg;

import java.util.LinkedList;
import java.util.List;

public class Solution57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals.length == 0){
            return new int[][]{newInterval};
        }

        List<int[]> list = new LinkedList<>();

        boolean flag = false;
        for (int[] it : intervals) {

            //判断交集

            if ((it[0] <= newInterval[0] && it[1] >= newInterval[0]) ||
                    (it[0] <= newInterval[1] && it[1] >= newInterval[1]) ||
                    (newInterval[0] <= it[0] && newInterval[1] >= it[0])) {

                newInterval[0] = Math.min(newInterval[0], it[0]);
                newInterval[1] = Math.max(newInterval[1], it[1]);

                //是否添加
                if(!flag){
                    flag = true;
                    list.add(newInterval);
                }

            } else {
                //没有交集
                if(!flag && newInterval[1] < it[0]){
                    list.add(newInterval);
                    flag = true;
                }
                list.add(it);
            }

        }

        if(!flag){
            list.add(newInterval);
        }

        return list.toArray(new int[list.size()][]);
    }

}
