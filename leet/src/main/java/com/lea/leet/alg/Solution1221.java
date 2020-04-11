package com.lea.leet.alg;

public class Solution1221 {

    public int balancedStringSplit(String s) {

        char pre = s.charAt(0);

        int cnt = 0;
        int preSize = 1;
        for(int i = 1; i < s.length(); i++){

            if(pre == s.charAt(i)){
                preSize++;
            }else{
                preSize--;
            }
            if(preSize == 0){
                cnt++;
                pre = s.charAt(i);
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

        String str = "RLLLLRRRLR";
        Solution1221 solution1221 = new Solution1221();
        System.out.println(solution1221.balancedStringSplit(str));

    }

}
