package com.lea.leet.alg;

import java.util.ArrayList;
import java.util.List;

public class Solution728 {

    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (success(i)) {
                result.add(i);
            }
        }

        return result;
    }

    public boolean success(int x) {

        if (x == 0) {
            return false;
        }

        int rest;
        int k = x;
        while (x != 0) {
            rest = x % 10;
            if (rest == 0 || k % rest != 0) {
                return false;
            }
            x /= 10;
        }

        return true;
    }

    public static void main(String[] args) {

        List<Integer> integers = new Solution728().selfDividingNumbers(1, 22);
        System.out.println(integers);


    }
}
