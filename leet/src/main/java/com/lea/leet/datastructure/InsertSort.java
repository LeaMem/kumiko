package com.lea.leet.datastructure;

/**
 * page 10
 */
public class InsertSort {

    public void insertSort(int[] A) {
        for (int j = 1; j < A.length; j++) {
            int key = A[j];
            //Insert A[j] to the sorted sequence A[1..j - 1]
            int i = j - 1;
            while (i >= 0 && A[i] < key) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{5, 2, 4, 6, 1, 3};
        new InsertSort().insertSort(A);
        System.out.println(A);
    }

}
