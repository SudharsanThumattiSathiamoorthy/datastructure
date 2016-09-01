package com.sudharsan.examples;

import java.util.Scanner;

public class BinarySearch {
	private static Scanner scanner;

	static public void main(final String... args) {
		
		System.out.println("Enter the no to search : ");
		scanner = new Scanner(System.in);

		final int key = scanner.nextInt();

		int a[] = {5,6,3,1,2,8};
		
		int low  = 0, high = a.length, mid;
		
		while (low < high) {
			mid = low + (high - low) / 2;
			
			if (a[mid] == key) {
				System.out.println("Bingo.. Found the key!!");
				return;
			} else if (key < a[mid]) {
				high = mid -1;
			} else {
				low = mid + 1;
			}
		}
	}
}
