package com.lea.leet.alg;

public class Solution860 {

    public boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;
        int twenty = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five <= 0) {
                    return false;
                }
                five--;
                ten++;
            } else if (bill == 20) {

                //10 5
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }

            }
        }

        return true;
    }


    public static void main(String[] args) {



    }

}
