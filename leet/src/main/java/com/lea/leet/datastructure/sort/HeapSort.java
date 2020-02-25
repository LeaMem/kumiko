package com.lea.leet.datastructure.sort;

public class HeapSort implements Sort {


    @Override
    public void sort(int[] arr) {
        heapSortAsc(arr, arr.length - 1);
    }


    /*
     * (最大)堆的向下调整算法
     *
     * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
     *     其中，N为数组下标索引值，如数组中第1个数对应的N为0。
     *
     * 参数说明：
     *     a -- 待排序的数组
     *     start -- 被下调节点的起始位置(一般为0，表示从第1个开始)
     *     end   -- 截至范围(一般为数组中最后一个元素的索引)
     */
    public static void maxHeapDown(int[] a, int start, int end) {

        int current = start;
        int l = 2 * current + 1;
        int tmp = a[current];

        while (l <= end) {

            if (l < end && a[l] < a[l + 1]) {
                l++;
            }

            if (tmp >= a[l]) {
                break;
            } else {
                a[current] = a[l];
                a[l] = tmp;
            }

            current = l;
            l = 2 * l + 1;
        }

    }

    public static void heapSortAsc(int[] a, int n) {

        /**
         *      这里是每次都要生成一个最大堆，
         *      然后整体就是最大堆了
         */
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapDown(a, i, n);
        }

        //从最后一个元素开始对序列进行调整
        for (int i = n; i > 0; i--) {

            int tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;

            //调整a[0...i - 1], 使得 a[0...i-1] 仍然是一个最大堆
            maxHeapDown(a, 0, i - 1);
        }
    }

    public static void main(String[] args) {

        int[] A = new int[]{5, 2, 4, 6, 1, 3};
        new HeapSort().sort(A);

        for (int it : A) {
            System.out.println(it);
        }

    }


}
