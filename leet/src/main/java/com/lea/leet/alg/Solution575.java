package com.lea.leet.alg;

import org.w3c.dom.css.CSSPrimitiveValue;

import java.util.HashSet;
import java.util.Set;

public class Solution575 {

    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (Integer it : candies) {
            set.add(it);
        }

        int res = set.size();
        int partition = candies.length / 2;

        //如果种类超过一半就返回res, 没有超过就返回糖的种类
        return res >= partition ? partition : set.size();
    }


    public static void main(String[] args) {

        int[] candies = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3};
        int i = new Solution575().distributeCandies(candies);
        System.out.println(i);

    }

}
