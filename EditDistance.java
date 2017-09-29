package com.sudharsan.examples;

public class EditDistance {

	public static int editDistance(final String s1,
			final String s2,
			final int m,
			final int n) {
		if (m == 0) {
			return n;
		}
		if (n == 0) {
			return m;
		}
		if (s1.charAt(m-1) == s2.charAt(n-1)) {
			return editDistance(s1, s2, m-1, n-1);
		}
		return 1 + min(editDistance(s1, s2, m, n-1),
				editDistance(s1, s2, m-1, n),
				editDistance(s1, s2, m-1, n-1));
	}
	private static int min(int x, int y, int z) {
		if (x < y && x < z) {
			return x;
		} else if (y < z) {
			return y;
		}
		return z;
	}
	public static void main(final String[] args) {
		final String s1 = "sunday";
	    final String s2 = "saturday";
	    System.out.println(editDistance(s1, s2, s1.length() -1, s2.length() -1));
	}
}
