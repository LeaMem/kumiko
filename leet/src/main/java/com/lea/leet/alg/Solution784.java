package com.lea.leet.alg;

import java.util.ArrayList;
import java.util.List;

public class Solution784 {

    public List<String> letterCasePermutation(String S) {

        List<String> list = new ArrayList<>();

        dfs(list, "", S, 0);

        return list;

    }

    public void dfs(List<String> list, String str, String s, int index) {

        if (index == s.length()) {
            list.add(str);
            return;
        }


        int f = index;
        int k = index;
        dfs(list, str + s.charAt(index), s, ++f);

        if (Character.isUpperCase(s.charAt(index))) {
            dfs(list, str + Character.toLowerCase(s.charAt(index)), s, ++k);
        } else if (Character.isLowerCase(s.charAt(index))) {
            dfs(list, str + Character.toUpperCase(s.charAt(index)), s, ++k);
        }

    }

    public static void main(String[] args) {

        String str = "a1b2";
        Solution784 solution784 = new Solution784();
        List<String> list = solution784.letterCasePermutation(str);

        for (String it : list) {
            System.out.println(it);
        }

    }

}
