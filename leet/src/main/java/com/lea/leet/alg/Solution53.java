package com.lea.leet.alg;

public class Solution53 {


    public int maxSubArray(int[] nums){

        if(nums.length == 0){
            return 0;
        }

        return calculate(nums, 0, nums.length - 1);
    }

    public int calculate(int[] nums, int l, int r){

        if(l == r){
            return nums[l];
        }

        int mid = (l + r) / 2;

        int leftMax = calculate(nums, l, mid);
        int rightMax = calculate(nums, mid + 1, r);

        int lSum = Integer.MIN_VALUE;
        int rSum = Integer.MIN_VALUE;

        int it = 0;
        for(int i = mid; i >= l; i--){
            it += nums[i];
            lSum = Math.max(lSum, it);
        }

        it = 0;
        for(int i = mid + 1; i <= r; i++){
            it += nums[i];
            rSum = Math.max(rSum, it);
        }

        return Math.max(Math.max(leftMax, rightMax), lSum + rSum);
    }

//    public int maxSubArray(int[] nums) {
//
//        int curMax = nums[0];
//        int sum = nums[0];
//
//        for(int i = 1; i < nums.length; i++){
//            curMax = Math.max(curMax + nums[i], nums[i]);
//            sum = Math.max(curMax, sum);
//        }
//
//        return sum;
//    }


    public static void main(String[] args) {
        Solution53 solution = new Solution53();
        System.out.println(solution.maxSubArray(new int[]{-2, -1}));
    }
}
