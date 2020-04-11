package com.lea.leet.alg;

public class Solution1281 {

    public int subtractProductAndSum(int n) {

        if(n == 0){
            return 0;
        }

        int pow = 1;
        int sum = 0;

        while (n > 0){

            int it = n % 10;
            n /= 10;
            pow *= it;
            sum += it;
        }

        return pow - sum;
    }

    public static void main(String[] args) {
        Solution1281 solution1281 = new Solution1281();
        int ans = solution1281.subtractProductAndSum(234);
        System.out.println(ans);
    }

}
