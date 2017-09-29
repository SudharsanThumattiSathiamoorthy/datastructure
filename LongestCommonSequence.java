package com.sudharsan.examples;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonSequence {

	public static int lcs(final String s1,
			final String s2,
			final int m,
			final int n,
			final Set<Character> chars) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (s1.charAt(m-1) == s2.charAt(n-1)) {
			chars.add(s1.charAt(m-1));
			return 1 + lcs(s1, s2, m-1, n-1, chars);
		}
		return max(lcs(s1, s2, m, n-1, chars), lcs(s1, s2, m-1, n, chars));
	}
	private static int max(int x, int y) {
		return x > y ? x : y;
	}
	public static void main(final String[] args) {
		final String s1 = "sunday";
	    final String s2 = "saturday";
	    final Set<Character> chars = new HashSet<>();

	    System.out.println(lcs(s1, s2, s1.length() -1, s2.length() -1, chars));
	    System.out.println(chars);
	}
}
