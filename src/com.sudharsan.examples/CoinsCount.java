package com.sudharsan.examples;

public class CoinsCount {

	public static void main(final String[] arg) {
		int[] a = {1, 2, 3};
		System.out.println(count(a, a.length, 4));
	}
	
	static int count(int[] a, int m, int n) {
		if (n == 0) {
			return 1;
		}
		
		if (n <= 0) {
			return 0;
		}
		
		if (m <= 0 && n >= 1) {
			return 0;
		}
		
		return count(a, m-1, n) + count(a, m, n-a[m-1]);
	}
}
