package com.sudharsan.examples;

public class HigherNo {

	public static void main(final String[] args) {
		final String no = "34876314";
		
		System.out.println(checkIfNoIsAscending(no.toCharArray()));
		
		System.out.println(checkIfNoIsDescending(no.toCharArray()));
		
		findHigherNo(no.toCharArray());
	}

	private static void findHigherNo(char[] a) {
		
		int index = 0;
		for (int i = a.length -1 ; i >= 1 ; i--) {
			if (a[i-1] < a[i]) {
				index = i-1;
				break;
			}
		}
		System.out.println("index : " + index);
		swap(a, a.length-1, index);
		
		System.out.println(String.valueOf(a));
	}

	private static void swap(char[] a, int i, int index) {
		char temp = a[i];
		a[i] = a[index];
		a[index] = temp;
	}

	private static boolean checkIfNoIsDescending(char[] a) {
		for (int i = a.length -1 ; i >= 1 ; i--) {
			if (!(a[i] > a[i-1])) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkIfNoIsAscending(final char[] a) {
		for (int i = 0; i < a.length - 2 ; i++) {
			if (!(a[i] < a[i+1])) {
				return false;
			}
		}
		return true;
	}
	
	
}
