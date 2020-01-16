package com.lea.leet.alg;

public class Solution58 {

    public int lengthOfLastWord(String s) {

        String[] split = s.split("\\s+");

        if(split.length == 0){
            return 0;
        }

        return split[split.length - 1].length();
    }


    public static void main(String[] args) {
        int len = new Solution58().lengthOfLastWord(" ");
        System.out.println(len);
    }

}
