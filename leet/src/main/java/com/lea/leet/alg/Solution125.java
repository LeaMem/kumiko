package com.lea.leet.alg;

public class Solution125 {

    public boolean isPalindrome(String s) {

        String str = getStr(s);

        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public String getStr(String s) {

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(('0' <= s.charAt(i) && '9' >= s.charAt(i)) || ('a' <= s.charAt(i) && s.charAt(i) <= 'z') ||
                    ('A' <= s.charAt(i) && s.charAt(i) <= 'Z')){
                builder.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {

        String str = "A man, a plan, a canal: Panama";
        Solution125 solution125 = new Solution125();
        boolean ans = solution125.isPalindrome(str);
        System.out.println(ans);

    }

}
