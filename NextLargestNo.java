package com.sudharsan.examples;
import java.util.Arrays;

public class NextLargestNo {

	static public void main(final String[] args) {
		// Some Random no.
		int no = 218765;

		// Descending No.
		// int no = 654321;

		// Ascending No.
		// int no = 123456;

		boolean descendingFlag = checkIfNoIsDescending(no);
		if (descendingFlag) {
			System.out.println("Next Largest no cannot be found.");
			return;
		}

		boolean ascendingFlag = checkIfNoIsAscending(no);
		if (ascendingFlag) {
			final String largestNo = swapLastTwoDigits(String.valueOf(no).toCharArray());
			System.out.println(largestNo);
			return;
		}

		final String largestNo = findNextLargestNo(no);
		System.out.println("Largest No : " + largestNo);
	}

	private static String findNextLargestNo(int no) {
		char a[] = String.valueOf(no).toCharArray();

		int index = a.length - 1;
		for (int i = a.length - 1; i > 0; i--) {
			if (a[i - 1] < a[i]) {
				index = i - 1;
				break;
			}
		}

		int minIndex = index + 1;
		for (int i = index + 2; i <= a.length - 1; i++) {
			if (a[i] < a[minIndex]) {
				minIndex = i;
			}
		}

		swap(a, minIndex, index);
		Arrays.sort(a, index + 1, a.length);

		return String.valueOf(a);
	}

	private static void swap(char[] a, int minIndex, int index) {
		char temp = a[minIndex];
		a[minIndex] = a[index];
		a[index] = temp;
	}

	private static String swapLastTwoDigits(char[] charArray) {
		int length = charArray.length - 1;
		char temp = charArray[length];
		charArray[length] = charArray[length - 1];
		charArray[length - 1] = temp;

		return String.valueOf(charArray);
	}

	private static boolean checkIfNoIsAscending(int no) {
		int curr = no % 10;
		no /= 10;

		while (no != 0) {
			int prev = no % 10;

			if (!(prev <= curr)) {
				return false;
			}
			prev = curr;
			no /= 10;
		}
		return true;
	}

	private static boolean checkIfNoIsDescending(int no) {
		if (no == 0) {
			return true;
		}

		int currNo = no % 10;
		no = no / 10;

		while (no != 0) {
			int nextNo = no % 10;

			if (!(nextNo >= currNo)) {
				return false;
			}
			currNo = nextNo;
			no /= 10;
		}
		return true;
	}
}
