package com.lea.leet.alg;


public class Solution171 {

	public int titleToNumber(String s) {
		int sum = 0;
		int rest = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			sum += (s.charAt(i) - 'A' + 1) * rest;
			rest *= 26;
		}
		return sum;
	}

	public static void main(String[] args) {
		Solution171 solution171 = new Solution171();
		int zy = solution171.titleToNumber("AB");
		System.out.println(zy);
	}
}
