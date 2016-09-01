package com.sudharsan.examples;

import org.apache.commons.lang3.StringUtils;

public class PatternExample {

	static public void main(final String... args) {
		
		final String key = "MacBook";
		final String value = "MacBook9,1";
		
		boolean matches = value.regionMatches(0, key, 0, key.length());
		System.out.println(matches);
		
		matches = "MachBook10,1".regionMatches(0, key, 0, key.length());
		System.out.println(matches);
		
		matches = StringUtils.startsWithIgnoreCase("macbook9.1", "MacBook");
		System.out.println(matches);
		
		matches = StringUtils.startsWithIgnoreCase("MaccBok9,1", "MacBook");
		System.out.println(matches);
	}
}
