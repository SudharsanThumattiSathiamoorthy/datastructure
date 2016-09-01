package com.sudharsan.examples;

public class FibonacciSeries {

	public static void main(String[] args) {
		
//		int prev=0, next =1, sum = 0;
//		
//		for(int i=0;i<=10;i++) {
//			System.out.println(sum);
//			sum = prev + next;
//			prev = next;
//			next = sum;
//		}
		
		permutation("ABC");
		
	}

	private static void permutation(String string) {
		
		if (string == null || string.length() == 0) {
			return;
		}
		
		System.out.println(string.charAt(0));
		System.out.println(string.substring(1));
		
		permutation(string.substring(1));
	}
}
