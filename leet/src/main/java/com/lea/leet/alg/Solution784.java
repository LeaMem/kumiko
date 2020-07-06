package com.lea.leet.alg;

import java.util.ArrayList;
import java.util.List;

public class Solution784 {

    public List<String> letterCasePermutation(String S) {

        List<String> list = new ArrayList<>();

        dfs(list, new StringBuilder(S), 0);

        return list;

    }

    public void dfs(List<String> list, StringBuilder builder, int index){



    }

    public static void main(String[] args) {

        String str = "a1b2";
        Solution784 solution784 = new Solution784();
        List<String> list = solution784.letterCasePermutation(str);

        for(String it : list){
            System.out.println(it);
        }

    }

}
