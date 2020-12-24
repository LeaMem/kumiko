package com.lea.leet.replay;

public class Resolution96 {

	public int numTrees(int n) {
		int[] ans = new int[n + 1];
		ans[0] = 1;
		ans[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			for(int j = 1; j < i + 1; j++){
				ans[i] += ans[i - 1] * ans[n - i];
			}
		}

		return ans[n];
	}

	public static void main(String[] args) {

		

	}
}
