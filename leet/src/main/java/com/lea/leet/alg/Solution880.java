package com.lea.leet.alg;

public class Solution880 {

    public String decodeAtIndex(String S, int K) {

        long size = 0;
        for(int i = 0; i < S.length(); i++){
            if(Character.isDigit(S.charAt(i))){
                size *= S.charAt(i) - '0';
            }else{
                size++;
            }
        }

        for (int i = S.length() - 1; i >= 0; i--){
            char ch = S.charAt(i);
            K %= size;
            if(K == 0 && Character.isLetter(ch)){
                return Character.toString(ch);
            }

            if(Character.isDigit(ch)){
                size /= ch - '0';
            }else{
                size--;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Solution880 solution880 = new Solution880();
//        String ans = solution880.decodeAtIndex("yyuele72uthzyoeut7oyku2yqmghy5luy9qguc28ukav7an6a2bvizhph35t86qicv4gyeo6av7gerovv5lnw47954bsv2xruaej", 123365626);
        String ans = solution880.decodeAtIndex("a2345678999999999999999", 1);
        System.out.println(ans);


    }

}
