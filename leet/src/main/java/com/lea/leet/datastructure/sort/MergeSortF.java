package com.lea.leet.datastructure.sort;

public class MergeSortF implements Sort {


    @Override
    public void sort(int[] arr) {

        for (int i = 1; i < arr.length; i *= 2) {

            for (int j = 0; j + i < arr.length; j += 2 * i) {

                int first = 0;
                int second = 0;
                int k = 0;

                int[] tmp = new int[2 * i];

                while (first < i && second < i && second + j + i < arr.length) {

                    if (arr[j + first] < arr[j + i + second]) {
                        tmp[k] = arr[j + first];
                        first++;
                    } else {
                        tmp[k] = arr[j + i + second];
                        second++;
                    }
                    k++;
                }

                while (first < i) {
                    tmp[k] = arr[j + first];
                    k++;
                    first++;
                }

                while (second < i && second + j + i < arr.length) {
                    tmp[k] = arr[j + i + second];
                    k++;
                    second++;
                }

                for (int u = 0; u < k; u++) {
                    arr[j + u] = tmp[u];
                }

            }
        }

    }

    public static void main(String[] args) {
        int[] A = new int[]{5, 2, 4, 6, 1, 3};
        new MergeSortF().sort(A);

        for (int it : A) {
            System.out.println(it);
        }
    }
}
