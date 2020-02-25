package com.lea.leet.datastructure.sort;

public class ShellSort implements Sort {


    @Override
    public void sort(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {

                int k = i - gap;
                int tmp = arr[i];
                while (k >= 0 && tmp < arr[k]) {
                    arr[k + gap] = arr[k];
                    k -= gap;
                }
                arr[k + gap] = tmp;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
        Sort sort = new ShellSort();
        sort.sort(arr);

        for (int it : arr) {
            System.out.println(it);
        }
    }

}
