package com.lea.leet.datastructure.sort;


import java.util.Arrays;

/**
 * 32
 */
public class MergeSort {


    public static void mergeSort(int[] arr) {

        //使用非递归的方式排序
        int len = arr.length;
        int k = 1;

        while (k < len) {
            mergePass(arr, k, len);
            k *= 2;
        }

    }

    //MergePass方法负责将数组中相邻的有K个元素的字符列进行归并
    public static void mergePass(int[] arr, int k, int n) {

        int i = 0;

        //从前往后，将2个长度为k的子序列合并为1个
        while (i < n - 2 * k + 1) {
            merge(arr, i, i + k - 1, i + 2 * k - 1);
            i += 2 * k;
        }


        //这段代码保证了，将那些“落单的”长度不足两两merge的部分和前面merge起来。
        if (i < n - k) {
            merge(arr, i, i + k - 1, n - 1);
        }

    }


    //merge函数实际上是将两个有序数组合并成一个有序数组
    //因为数组有序，合并很简单，只要维护几个指针就可以了
    private static void merge(int[] arr, int low, int mid, int high) {
        //temp数组用于暂存合并的结果
        int[] temp = new int[high - low + 1];
        //左半边的指针
        int i = low;
        //右半边的指针
        int j = mid + 1;
        //合并后数组的指针
        int k = 0;

        //将记录由小到大地放进temp数组
        for (; i <= mid && j <= high; k++) {
            if (arr[i] < arr[j])
                temp[k] = arr[i++];
            else
                temp[k] = arr[j++];
        }

        //接下来两个while循环是为了将剩余的（比另一边多出来的个数）放到temp数组中
        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= high)
            temp[k++] = arr[j++];

        //将temp数组中的元素写入到待排数组中
        for (int l = 0; l < temp.length; l++)
            arr[low + l] = temp[l];
    }


    public static void main(String[] args) {

        int[] arr = {12, 11, 13, 5, 6, 7};
        new MergeSort().mergeSort(arr);

        Arrays.stream(arr)
                .forEach(System.out::println);

    }

}
