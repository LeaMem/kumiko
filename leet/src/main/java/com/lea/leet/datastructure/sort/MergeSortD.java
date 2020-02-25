package com.lea.leet.datastructure.sort;

public class MergeSortD implements Sort {


    @Override
    public void sort(int[] arr) {

        mergeSort(arr, 0, arr.length - 1);

    }

    private void mergeSort(int[] arr, int left, int right) {

        int mid = (left + right) / 2;

        if (left < right) {
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
        }

        int[] tmp = new int[right - left + 1];

        int first = left;
        int second = mid + 1;
        int start = 0;

        while (first <= mid && second <= right) {
            if (arr[first] < arr[second]) {
                tmp[start] = arr[first];
                first++;
            } else {
                tmp[start] = arr[second];
                second++;
            }
            start++;
        }

        while (first <= mid) {
            tmp[start] = arr[first];
            start++;
            first++;
        }

        while (second <= right) {
            tmp[start] = arr[second];
            start++;
            second++;
        }

        for (int i = 0; i < start; i++) {
            arr[left] = tmp[i];
            left++;
        }

    }

    public static void main(String[] args) {
        int[] A = new int[]{5, 2, 4, 6, 1, 3};
        new MergeSortD().sort(A);

        for (int it : A) {
            System.out.println(it);
        }
    }
}
