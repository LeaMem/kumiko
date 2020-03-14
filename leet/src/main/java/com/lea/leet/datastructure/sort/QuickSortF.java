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

    public static void main(String[] args) {

        int[] A = new int[]{5, 2, 4, 6, 1, 3};
        int partition = new QuickSortF().partition(A, 0, A.length - 1);
        System.out.println(partition);

        for (int it : A) {
            System.out.println(it);
        }

    }

    public static int partition(int[] arr, int l, int r){
        int tmp = arr[r];

        for(int i = l; i < r; i++){
            //放到前面
            if(tmp > arr[i]){
                int k = arr[l];
                arr[l] = arr[i];
                arr[i] = k;
                l++;
            }
        }

        int k = arr[l];
        arr[l] = arr[r];
        arr[r] = k;

        return l;
    }

//
//    public static int partition(int[] arr, int start, int end) {
//
//        int pivot = arr[end];
//        for (int i = start; i < end; i++) {
//
//            if (arr[i] < pivot) {
//                int tmp = arr[start];
//                arr[start] = arr[i];
//                arr[i] = tmp;
//                start++;
//            }
//
//        }
//
//        int tmp = arr[start];
//        arr[start] = pivot;
//        arr[end] = tmp;
//
//        return start;
//
//    }


    public static class Record {

        public int start;

        public int end;

        public Record(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


}
