package com.lea.leet.forjob;

public class ForJob215S {

    public int findKthLargest(int[] nums, int k) {
        return find(nums, 0, nums.length - 1, nums.length - k);
    }

    public int find(int[] nums, int left, int right, int k) {
        int partition = partition(nums, left, right);
        if (partition == k) {
            return nums[k];
        } else if (partition < k) {
            return find(nums, left + 1, right, k);
        } else {
            return find(nums, left, right - 1, k);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int slot = left;
        int index = slot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[slot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, slot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
//        ForJob215S forJob215S = new ForJob215S();
//        int kthLargest = forJob215S.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
//        System.out.println(kthLargest);
        System.out.println(Integer.MAX_VALUE);
        System.out.println((1 << (32 - 16)) - 1);
        System.out.println(1 << 32 - 1);
    }

}
