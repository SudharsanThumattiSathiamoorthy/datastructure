package com.sudharsan.examples;

import java.util.Arrays;

public class RemoveDuplicatesInSortedArray {
	static public void main(final String[] args) {
		int[] a = {1, 2, 2, 3, 3, 3, 4, 6, 6, 8, 8, 9, 9, 10};

		int b[] = removeDuplicates(a);
		System.out.println(Arrays.toString(b));
	}

	private static int[] removeDuplicates(final int[] a) {
		if (a != null  && a.length <= 2) {
			return a;
		}

		int i = 0, j = 1;
		while (j < a.length -1 ) {
			if (a[i] != a[j]) {
				i++;
				j++;
			} else {
				while(a[i] == a[j]) {
					j++;
				}
				i++;
				a[i] = a[j];
			}
		}
		return Arrays.copyOf(a, i + 1);
	}
}
