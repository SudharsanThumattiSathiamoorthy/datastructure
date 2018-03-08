package com.sudharsan.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HelloWorld {
	
	public static void main(final String... args) {
		hello("adsf");
	}
	
	public static String hello(final String name) {
		String.format("%s : %s"  , "hello", name);
		
		
		List<String> stringList = Arrays.asList("a", "b", "c");
		
		System.out.println(stringList.stream()
		.map(value -> (String)value)
		.collect(Collectors.joining(", ")));
		return null;
	}
}
