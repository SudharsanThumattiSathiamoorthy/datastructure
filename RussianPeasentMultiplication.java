package com.sudharsan.examples;

public class RussianPeasentMultiplication {
	
	static public void main(final String... arg) {
		int a = 18, b = 20;
		
		int result = 0;
		
		while (b > 0) {
			 
			if ((1 & b) == 1) {
				result += a;
			}
			
			a = a << 1;
			b = b >> 1;
		}
		
		System.out.println("Result  " + result);
	}
}
