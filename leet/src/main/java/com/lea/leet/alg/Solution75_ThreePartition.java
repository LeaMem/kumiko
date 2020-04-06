package com.lea.leet.alg;

/**
 * 感觉还是老丢厉害
 */
public class Solution75_ThreePartition {


    public void sort(int[] nums, int l, int r) {

        if (l < r) {

            int tmp = nums[l];
            int lt = l;
            int gt = r;
            int i = l + 1;

            while (i <= gt) {

                if (nums[i] == tmp) {
                    i++;

                } else if (nums[i] < tmp) {

                    //放到前面
                    int k = nums[i];
                    nums[i] = nums[lt];
                    nums[lt] = k;
                    lt++;
                    i++;

                } else {


                    /**
                     *      这里打死我也想不到，只要 gt--就可以了
                     */
                    int k = nums[i];
                    nums[i] = nums[gt];
                    nums[gt] = k;
                    gt--;

                }

            }

            sort(nums, l, lt - 1);
            sort(nums, gt + 1, r);
        }

    }

    public static void main(String[] args) {
        int[] nums = {0,1,2};
        new Solution75_ThreePartition().sort(nums, 0, nums.length - 1);

        for(int it : nums){
            System.out.println(it);
        }
    }

}
