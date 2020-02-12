package com.lea.leet.datastructure;

public class MergeSort3 {

    public static void sort(int[] arr) {

        for (int i = 1; i < arr.length; i *= 2) {


            for (int j = 0; j + i < arr.length; j += 2 * i) {

                int[] tmp = new int[2 * i];
                int f = 0, s = 0, k = 0;
                while (f < i && s < i && j + i + s < arr.length) {

                    if (arr[j + f] < arr[j + i + s]) {
                        tmp[k] = arr[j + f];
                        f++;
                    } else {
                        tmp[k] = arr[j + i + s];
                        s++;
                    }
                    k++;
                }

                while (f < i) {
                    tmp[k] = arr[j + f];
                    k++;
                    f++;
                }

                while (s < i && j + i + s < arr.length) {
                    tmp[k] = arr[j + i + s];
                    k++;
                    s++;
                }

                for (int t = 0; t < k; t++) {
                    arr[j + t] = tmp[t];
                }

            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 4, 6, 1};
        MergeSort3.sort(arr);
        for (int value : arr) {
            System.out.println(value);
        }
    }

}
