package com.lea.leet.alg;

import java.util.ArrayList;
import java.util.List;

/**
 *      未做
 */
public class Solution658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int size = arr.length;

        int left = 0;
        int right = size - k;

        while (left < right) {

            int mid = (left + right) / 2;

            //从长度为 k + 1的连续子区间删除一个元素
            if(x - arr[mid] > arr[mid + k] - x){
                left = mid + 1;
            }else{
                right = mid;
            }

        }



        return new ArrayList<>();
    }


    public static void main(String[] args) {
        new Solution658().findClosestElements(new int[]{1,2,3,4,5}, 4, 3);
    }
}
