package com.lea.leet.datastructure;

/**
 * https://www.java67.com/2018/03/mergesort-in-java-algorithm-example-and.html
 */
public class MergeSort2 {

    public static void mergeSort(int[] input) {

        mergeSort(input, 0, input.length - 1);

    }

    public static void mergeSort(int[] input, int start, int end) {

        int mid = (start + end) / 2;
        if (start < end) {
            mergeSort(input, start, mid);
            mergeSort(input, mid + 1, end);
        }

        int i = 0, first = start, last = mid + 1;
        int[] tmp = new int[end - start + 1];


        while (first <= mid && last <= end) {
            tmp[i++] = input[first] < input[last]
                    ? input[first++] : input[last++];
        }

        while (first <= mid) {
            tmp[i++] = input[first++];
        }

        while (last <= end) {
            tmp[i++] = input[last++];
        }

        i = 0;
        while (start <= end) {
            input[start++] = tmp[i++];
        }

    }

    public static void main(String[] args) {

    }

}
