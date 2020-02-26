package com.lea.leet.datastructure.sort;

public class QuickSortD implements Sort {


    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] a, int l, int r){

        if(l < r){

            int i = l;
            int j = r;
            int x = a[i];
            while(i < j){

                //从右向左找第一个小于x的数
                while(i < j && a[j] > x){
                    j--;
                }

                if(i < j){
                    a[i++] = a[j];
                }

                //从左向右找到第一个大于x的数
                while(i < j && a[i] < x){
                    i++;
                }

                if(i < j){
                    a[j--] = a[i];
                }
            }

            a[i] = x;
            quickSort(a, l, i - 1);
            quickSort(a, i + 1, r);
        }

    }

    public static void main(String[] args) {

        int[] A = new int[]{5, 2, 4, 6, 1, 3};
        new QuickSortD().sort(A);

        for (int it : A) {
            System.out.println(it);
        }

    }
}
