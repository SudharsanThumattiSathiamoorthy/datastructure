package com.sudharsan.examples;

import java.util.Scanner;

public class AngryProfessor {

	public static void main(final String... args) {
		final Scanner scanner = new Scanner(System.in);
		final int noOfTestCases = scanner.nextInt();
		
		for (int i = 1; i <= noOfTestCases ;i++) {
			final int noOfStudents = scanner.nextInt();
			final int threshold = scanner.nextInt();
			
			int counter = 0;
			for (int j = 1; j <= noOfStudents ; j++) {
				final int time = scanner.nextInt();
				counter += time > 0 ? 1 : 0;
			}
			if (counter >= threshold) {
				System.out.println("YES");
			} else{
				System.out.println("NO");
			}
		}
		final int i = 9;
		switch(i) {
		case 1:
			break;
		case 2:
		}
	}
}
