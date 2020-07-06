package com.lea.leet.alg;

import java.util.HashSet;
import java.util.Set;

public class Solution668 {


    public boolean isHappy(int n) {

        Set<Long> set = new HashSet<>();
        long x = n;

        while(x != 1){
            x = calc(x);
            if(!set.add(x)){
                return false;
            }
        }

        return true;
    }

    public long calc(long x) {
        long sum = 0;
        while (x > 0) {
            long tmp = x % 10;
            x /= 10;
            sum += tmp * tmp;
        }
        return sum;
    }

    public static void main(String[] args) {

        Solution668 solution668 = new Solution668();
        boolean ans = solution668.isHappy(19);
        System.out.println(ans);
    }

}
