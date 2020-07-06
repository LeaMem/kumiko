package com.lea.leet.alg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution434 {

    public int countSegments(String s) {

        Pattern pattern = Pattern.compile("([^\\s])+");
        Matcher matcher = pattern.matcher(s);

        int cnt = 0;
        while(matcher.find()){
            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {

        String str = ", , , ,        a, eaefa";
        Solution434 solution434 = new Solution434();
        int ans = solution434.countSegments(str);
        System.out.println(ans);
    }
}
