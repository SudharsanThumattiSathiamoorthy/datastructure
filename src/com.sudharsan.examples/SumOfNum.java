package com.sudharsan.examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfNum {

	private static final Pattern PIN_PATTERN = Pattern.compile("^[0-9]*{6}$");
	
	public static void main(final String args[]) {
		
		matches("757");
		matches("757980");
		matches("75798a");
		matches("");
		matches("1");
	}

	public static void matches(final String input) {
		final Matcher matcher = PIN_PATTERN.matcher(input);
		System.out.println(matcher.matches());
	}

	public int sum(final Input input) {
		return input.getNum1() + input.getNum2();
	}
}
