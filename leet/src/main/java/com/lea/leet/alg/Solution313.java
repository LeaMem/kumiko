package com.lea.leet.alg;

import java.util.*;

/**
 *      这里溢出了，我好难受呀
 *      最优解应该是用动态规划
 *      我现在还不会
 */
public class Solution313 {


    public int nthSuperUglyNumber(int n, int[] primes) {

        TreeSet<Long> treeSet = new TreeSet<>();
        treeSet.add(1L);

        while (n > 1) {
            long tmp = treeSet.pollFirst();

            for (int it : primes) {
                treeSet.add(tmp * it);
            }

            n--;
        }

        return treeSet.pollFirst().intValue();
    }


    public static void main(String[] args) {

//        int[] ans = {2,3,11,13,19,29,31,37,41,47};
        int[] ans = {7, 19, 29, 37, 41, 47, 53, 59, 61, 79, 83, 89, 101, 103, 109, 127, 131, 137, 139, 157, 167, 179, 181, 199, 211, 229, 233, 239, 241, 251};

        Solution313 solution313 = new Solution313();

//        int res = solution313.nthSuperUglyNumber(95, ans);
        int res = solution313.nthSuperUglyNumber(100000, ans);

        System.out.println(res);
    }

}
