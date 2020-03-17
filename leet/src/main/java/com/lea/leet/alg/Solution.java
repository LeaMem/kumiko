package com.lea.leet.alg;

import java.util.Random;

/**
 * 384
 */
public class Solution {

    private int[] arr;

    public Solution(int[] nums) {
        this.arr = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return arr;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {

        int[] target = new int[arr.length];

        System.arraycopy(arr, 0, target, 0, arr.length);


        Random random = new Random();
        for (int i = target.length - 1; i > 0; i--) {

            int idx = random.nextInt(i + 1);
            int tmp = target[i];
            target[i] = target[idx];
            target[idx] = tmp;

        }

        return target;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3};
        Solution solution = new Solution(arr);
        int[] shuffle = solution.shuffle();
        for(int it : shuffle){
            System.out.println(it);
        }
    }

}
