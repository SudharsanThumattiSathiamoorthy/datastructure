package com.sudharsan.examples;

public class GCD {

	static public void main(final String[] args) {

		int n1 = 9;
		int n2 = 10;

		int gcd = gcd (n2, n1);
		System.out.println("GCD : " + gcd);
	}

	private static int gcd(final int n1, final int n2) {
		if (n2 != 0) {
			gcd(n2, n1 % n2);
		}
		return n1;
	}
}
