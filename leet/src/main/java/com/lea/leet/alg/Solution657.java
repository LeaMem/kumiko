package com.lea.leet.alg;

public class Solution657 {

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for(Character ch : moves.toCharArray()){
            switch (ch){
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'R':
                    x++;
                    break;
                case 'L':
                    x--;
                    break;
                default:

            }
        }
        return x == 0 && y == 0;
    }

}
