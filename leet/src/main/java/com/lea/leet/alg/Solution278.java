package com.lea.leet.alg;

public class Solution278 {

	public int firstBadVersion(int n) {
		long l = 1;
		long r = n;
//		while (l < r) {
//			long mid = (l + r) / 2;
//			if (isBadVersion((int)mid)){
//				r = mid;
//			}else{
//				l = mid + 1;
//			}
//		}
		return (int) l;

	}

}
