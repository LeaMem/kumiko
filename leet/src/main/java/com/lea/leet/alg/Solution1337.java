package com.lea.leet.alg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution1337 {


    public int[] kWeakestRows(int[][] mat, int k) {

        List<KW> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            list.add(new KW(i, count(mat[i])));
        }

        list.sort(Comparator.comparingInt(o -> o.cnt));

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).index;
        }

//        int[] target = new int[mat.length];
//
//        for (int i = 0; i < mat.length; i++) {
//            target[i] = count(mat[i]);
//        }
//
//        for (int i = (target.length - 1) / 2 - 1; i >= 0; i--) {
//            down(target, i, target.length - 1);
//        }
//
//        for (int i = target.length - 1; i > 0; i--) {
//            int tmp = target[0];
//            target[0] = target[i];
//            target[i] = tmp;
//            down(target, 0, i - 1);
//        }

        return res;
    }

    public static class KW {
        public int index;
        public int cnt;

        public KW(int index, int cnt) {
            this.index = index;
            this.cnt = cnt;
        }
    }


    public int count(int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                break;
            }else{
                count++;
            }
        }
//        int l = 0;
//        int r = arr.length - 1;
//
//        while (l < r) {
//            int mid = l + (r - l) / 2;
//
//            if (arr[mid] == 1) {
//                l = mid + 1;
//            } else {
//                r = mid;
//            }
//        }
//
//        return l;
        return count;
    }

    public void heapSort(int[] target) {
        for (int i = (target.length - 1) / 2 - 1; i >= 0; i--) {
            down(target, i, target.length - 1);
        }

        for (int i = target.length - 1; i > 0; i--) {
            int tmp = target[0];
            target[0] = target[i];
            target[i] = tmp;
            down(target, 0, i - 1);
        }
    }

    public void down(int[] arr, int index, int n) {

        int l = 2 * index + 1;
        int tmp = arr[index];

        while (l <= n) {

            if (l < n && arr[l] < arr[l + 1]) {
                l++;
            }

            if (tmp < arr[l]) {
                arr[index] = arr[l];
                arr[l] = tmp;
            } else {
                break;
            }

            index = l;
            l = 2 * l + 1;
        }

    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1}
        };

        System.out.println(new Solution1337().count(new int[]{1, 1, 1, 1, 1}));


//        Solution1337 solution1337 = new Solution1337();
//        int[] ints = solution1337.kWeakestRows(nums, 3);
//        for(int it : ints){
//            System.out.println(it);
//        }

        /**
         *      [[1,1,1,1,1],[1,0,0,0,0],[1,1,0,0,0],[1,1,1,1,0],[1,1,1,1,1]]
         *      5  1  2  4  5
         *
         *      1 2 3
         */

    }

}
