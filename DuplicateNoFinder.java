package com.sudharsan.examples;

public class DuplicateNoFinder {

	static public void main(final String... args) {
		//         0   1  2  3  4  5
		int a[] = { 3, 5, 6, 4, 2, 1 };
		
 		for (int i=0 ;i < a.length;i++) {
 			try {
	 			if (a[Math.abs(a[i])] < 0) {
					System.out.println("Duplicate no " + Math.abs(a[i]));
					return;
				}
 			} catch (ArrayIndexOutOfBoundsException e) {
 				continue;
 			}
			a[Math.abs(a[i])] = -a[Math.abs(a[i])];
		}
 		System.out.println("Duplicate no not found.");
	}
}
