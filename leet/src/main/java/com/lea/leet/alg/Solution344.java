package com.lea.leet.alg;

public class Solution344 {

	public void reverseString(char[] s) {
		for (int i = 0; i < s.length / 2; i++) {
			char tmp = s[i];
			s[i] = s[s.length - 1 - i];
			s[s.length - 1 - i] = tmp;
		}
	}

	public static void main(String[] args) {
		Solution344 solution344 = new Solution344();
		String s = "abcd";
		char[] chars = s.toCharArray();
		solution344.reverseString(chars);
		System.out.println(chars.length);
	}

}
