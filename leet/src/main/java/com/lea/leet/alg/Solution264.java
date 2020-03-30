package com.lea.leet.alg;

import java.util.TreeSet;

/**
 * 这里按道理是要用 dp 的，
 * 2020-03-29
 * 可是我不会 dp 现在
 */
public class Solution264 {

    public int nthUglyNumber(int n) {

        TreeSet<Long> treeSet = new TreeSet<>();
        treeSet.add(1L);

        int cnt = 0;
        Long pre = -1L;
        while (!treeSet.isEmpty()) {

            Long last = treeSet.pollFirst();
            if (last != pre) {
                pre = last;
                cnt++;
            }
            if (cnt == n) {
                break;
            }

            treeSet.add(last * 2);
            treeSet.add(last * 3);
            treeSet.add(last * 5);
        }

        return pre.intValue();
    }

    public static void main(String[] args) {

        //1, 2, 3, 4, 5, 6, 8, 9, 10, 12
        int i = new Solution264().nthUglyNumber(10);


    }

}
