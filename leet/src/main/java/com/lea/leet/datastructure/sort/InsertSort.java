package com.lea.leet.datastructure.sort;

/**
 * page 10
 */
public class InsertSort implements Sort {

    @Override
    public void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int k = i - 1;
            int tmp = arr[i];

            while (k >= 0 && tmp < arr[k]) {
                arr[k + 1] = arr[k];
                k--;
            }

            arr[k + 1] = tmp;
        }

    }

    public static void main(String[] args) {
        int[] A = new int[]{5, 2, 4, 6, 1, 3};
        new InsertSort().sort(A);

        for (int it : A) {
            System.out.println(it);
        }
    }
}
