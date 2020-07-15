package com.lea.leet.alg;

import java.util.ArrayList;
import java.util.List;

public class Solution165 {

    public int compareVersion(String version1, String version2) {
        List<Integer> f = getVersionList(version1);
        List<Integer> s = getVersionList(version2);
        int i = 0;
        int j = 0;
        while (i < f.size() && j < s.size()) {
            int first = f.get(i);
            int second = s.get(j);
            if (first < second) {
                return -1;
            }
            if (first > second) {
                return 1;
            }
            j++;
            i++;
        }

        if (i < f.size()) {
            return 1;
        }
        if (j < s.size()) {
            return -1;
        }

        return 0;
    }

    public List<Integer> getVersionList(String version) {

        List<Integer> list = new ArrayList<>();
        String[] split = version.split("\\.");
        for (String str : split) {
            list.add(Integer.parseInt(str));
        }

        while (!list.isEmpty() && list.get(list.size() - 1) == 0) {
            list.remove(list.size() - 1);
        }

        return list;
    }

    public static void main(String[] args) {
        String version1 = "1.0";
        String version2 = "1";
        Solution165 solution165 = new Solution165();
        int ans = solution165.compareVersion(version1, version2);
        System.out.println(ans);
    }

}
