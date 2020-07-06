package com.lea.leet.alg;

public class Solution1374 {

    public String generateTheString(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n - 1; i++){
            builder.append('a');
        }
        if(n % 2 == 0){
            builder.append('b');
        }else{
            builder.append("a");
        }

        return builder.toString();
    }

}
