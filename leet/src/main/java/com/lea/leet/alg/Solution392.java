package com.lea.leet.alg;

public class Solution392 {

//	public boolean isSubsequence(String s, String t) {
//		int i = 0;
//		int j = 0;
//		while (i < s.length() && j < t.length()) {
//			if(s.charAt(i) == t.charAt(j)){
//				i++;
//			}
//			j++;
//		}
//		return i == s.length();
//	}

	/**
	 *    通过保存路径，然后进行路径搜索
	 */
	public boolean isSubsequence(String s, String t) {

		t = " " + t;
		//先保存好路径, 第n个元素后面第一个 a-z 字母的位置
		int[][] dp = new int[t.length()][26];
		for (int i = 0; i < 26; i++) {
			int p = -1;
			for (int j = t.length() - 1; j >= 0; j--) {
				dp[j][i] = p;
				if (t.charAt(j) == i + 'a') {
					p = j;
				}
			}
		}

		int index = 0;
		for (char c : s.toCharArray()) {
			index = dp[index][c - 'a'];
			if (index == -1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution392 solution392 = new Solution392();
		solution392.isSubsequence("abc", "ahbgdc");
	}
}
