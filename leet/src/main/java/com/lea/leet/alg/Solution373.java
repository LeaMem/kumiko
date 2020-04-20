package com.lea.leet.alg;

import java.util.*;

public class Solution373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<Helper> heap = new PriorityQueue<>((o1, o2) -> o2.sum - o1.sum);

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {

                Helper helper = new Helper();
                List<Integer> list = Arrays.asList(nums1[i], nums2[j]);
                helper.list = list;
                helper.sum = nums1[i] + nums2[j];

                if (heap.size() < k) {
                    heap.add(helper);
                } else {
                    if (helper.sum < heap.peek().sum) {
                        heap.poll();
                        heap.add(helper);
                    }
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        while (!heap.isEmpty()) {
            list.add(heap.poll().list);
        }

        return list;
    }

    public static class Helper {
        private List<Integer> list;
        private int sum;
    }


    public static void main(String[] args) {

        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};

        List<List<Integer>> result = new Solution373().kSmallestPairs(nums1, nums2, 3);

        System.out.println(result.size());

    }

}
