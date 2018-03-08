package com.sudharsan.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatternSearch {
	static public void main(final String args[]) {
		final String pattern = "acc";
		final List<String> inputs = Arrays.asList( "cdf", "too", "hfgdt", "paa", "boo", "booo" );

		findPattern(pattern, inputs);
	}

	private static void findPattern(final String pattern, final List<String> inputs) {
		final String patternCode = convertIntoCode(pattern);
		for (final String input: inputs) {
			if (pattern.length() != input.length()) {
				continue;
			}

			final String inputCode = convertIntoCode(input);

			if (patternCode.equals(inputCode)) {
				System.out.println("Input matches with the pattern : " + input);
			}
		}
	}
	
	private static String convertIntoCode(final String input) {
		final char[] inputArray = input.toCharArray();

		final Map<Character, Character> map = new HashMap<>();
		String returnString = "";
		int key = 0;

		for (int i = 0; i < inputArray.length ; i++) {
			if (map.get(inputArray[i]) == null) {
				returnString += ++key;
				map.put(inputArray[i], inputArray[i]);
			} else {
				returnString += key;
			}
		}
		return returnString;
	}
}
