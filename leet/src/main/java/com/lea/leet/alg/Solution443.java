package com.lea.leet.alg;

public class Solution443 {

    public int compress(char[] chars) {

        int size = 0;
        int left = 0;
        int right = 0;
        while(right < chars.length){

            if(chars[left] != chars[right]){
                size = add(chars, left, right, size);
                left = right;
            }

            right++;
        }

        if(right == chars.length){
            size = add(chars, left, right, size);
        }

        return size;
    }

    public int add(char[] chars, int left, int right, int size){

        chars[size++] = chars[left];
        int cnt = right - left;
        if(cnt > 1){
            for(char it : String.valueOf(cnt).toCharArray()){
                chars[size++] = it;
            }
        }

        return size;
    }

    public static void main(String[] args) {

        char[] chars = {'a'};
        Solution443 solution443 = new Solution443();
        int ans = solution443.compress(chars);
        System.out.println(ans);


    }

}
