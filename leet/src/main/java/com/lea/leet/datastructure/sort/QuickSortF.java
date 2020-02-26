package com.lea.leet.datastructure.sort;

import java.util.Deque;
import java.util.LinkedList;

public class QuickSortF implements Sort {


    @Override
    public void sort(int[] arr) {

        Deque<Record> deque = new LinkedList<>();

        deque.add(new Record(0, arr.length - 1));

        while (!deque.isEmpty()) {

            Record pop = deque.pop();

            int i = pop.start;
            int j = pop.end;
            int tmp = arr[i];

            while (i < j) {

                //从右往左找第一个小于 tmp 的位置
                while (i < j && tmp < arr[j]) {
                    j--;
                }

                if (i < j) {
                    arr[i++] = arr[j];
                }

                //从左往右找到第一个大于 tmp 的位置
                while (i < j && tmp > arr[i]) {
                    i++;
                }

                if (i < j) {
                    arr[j--] = arr[i];
                }

            }

            arr[i] = tmp;

            if (i > pop.start) {
                deque.add(new Record(pop.start, i - 1));
            }

            if (i < pop.end) {
                deque.add(new Record(i + 1, pop.end));
            }

        }

    }


    public static class Record {

        public int start;

        public int end;

        public Record(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {

        int[] A = new int[]{5, 2, 4, 6, 1, 3};
        new QuickSortF().sort(A);

        for (int it : A) {
            System.out.println(it);
        }

    }
}
