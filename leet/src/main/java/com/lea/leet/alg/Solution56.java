package com.lea.leet.alg;

import java.util.ArrayList;
import java.util.List;

public class Solution56 {

    public int[][] merge(int[][] intervals) {

        //先按照 start 排序，这里用快排序
        sort(intervals, 0, intervals.length - 1);

        List<int[]> list = new ArrayList<>();

        for (int[] it : intervals) {

            if (list.isEmpty()) {
                list.add(it);
            } else {

                int[] last = list.get(list.size() - 1);

                if (last[0] <= it[0] && last[1] >= it[0]) {
                    last[1] = Math.max(it[1], last[1]);
                } else {
                    list.add(it);
                }

            }
        }

        return list.toArray(new int[list.size()][]);
    }


    private void sort(int[][] intervals, int l, int r) {

        if (l < r) {

            int i = l;
            int j = r;
            int[] tmp = intervals[i];

            while (i < j) {

                while (i < j && tmp[0] < intervals[j][0]) {
                    j--;
                }

                if (i < j) {
                    intervals[i++] = intervals[j];
                }

                while (i < j && tmp[0] > intervals[i][0]) {
                    i++;
                }

                if (i < j) {
                    intervals[j--] = intervals[i];
                }
            }

            intervals[i] = tmp;

            sort(intervals, l, i - 1);
            sort(intervals, i + 1, r);
        }

    }

    public static void main(String[] args) {

        int[][] merge = new Solution56().merge(new int[][]{
                {8, 10},
                {15, 18},
                {1, 3},
                {2, 6}

        });

        System.out.println(merge.length);

    }

}
