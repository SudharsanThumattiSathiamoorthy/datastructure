package com.sudharsan.examples;

public class StringPermutation {

	public static void main(final String arg[]) {
		permute("ABC".toCharArray(), 0, 2);
	}

	private static void permute(final char[] a, final int start, final int end) {
		
		if (start == end) {
			System.out.println(String.valueOf(a));
		}
		
		for (int i= start ; i <= end; i++) {
			swap(a, i, start);
			permute(a, start+1, end);
			swap(a, i, start);
		}
	}

	private static void swap(char[] a, int start, int end) {
		char temp = a[start];
		a[start] = a[end];
		a[end] = temp;
	}
}
