package com.lea.leet.datastructure.sort;


public class QuickSortTT implements Sort {

    @Override
    public void sort(int[] arr) {

        quickSort(arr, 0, arr.length - 1);

    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }

    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{5, 2, 4, 3, 1, 6};
        Sort sort = new QuickSortTT();
        sort.sort(arr);

        for (int it : arr) {
            System.out.println(it);
        }
    }

}
