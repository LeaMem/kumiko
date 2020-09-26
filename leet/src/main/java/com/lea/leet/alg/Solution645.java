package com.lea.leet.alg;


public class Solution645 {

    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[nums.length + 1];
        for (int num : nums) {
            arr[num]++;
        }
        int[] ints = new int[2];
        for (int i = 1; i <= nums.length; i++) {
            if (arr[i] > 1) {
                ints[0] = i;
            }else if(arr[i] == 0){
                ints[1] = i;
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        Solution645 solution645 = new Solution645();
        int[] ans = solution645.findErrorNums(new int[]{1, 2, 2, 4});
        System.out.println(ans.length);
    }

}
