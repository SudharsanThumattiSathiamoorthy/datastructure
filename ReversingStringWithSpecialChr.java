package com.sudharsan.examples;

public class ReversingStringWithSpecialChr {

	static public void main(final String... arg) {
		
		final String input = "A!E,c";
		char[] charArray = input.toCharArray();
		
		for (int l = 0, r = charArray.length -1 ; l < r ;) {
			if (!Character.isAlphabetic(charArray[l])) {
				l++;
			} else if (!Character.isAlphabetic(charArray[r])) {
				r--;
			} else {
				swap(charArray, l, r);
				l++; r--;
			}
		}
		
		System.out.println("Reversed string : " + new String(charArray));
	}

	private static void swap(char[] charArray, int l, int r) {
		char temp = charArray[l];
		charArray[l] = charArray[r];
		charArray[r] = temp;
	}
}
