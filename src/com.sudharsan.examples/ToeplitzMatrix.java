package com.sudharsan.examples;

public class ToeplitzMatrix {

	static public void main(final String[] args) {
		int[][] matrix = { 
				{ 6, 7, 8, 9, 2 },
				{ 4, 6, 7, 8, 9 },
				{ 1, 4, 6, 7, 8 },
				{ 0, 1, 3, 6, 7 },
				{ 9, 8, 7, 5, 5} };

		if(checkIfItIsToeplitzMatrix(matrix)) {
			System.out.println("Yes. It is a topelitz matrix.");
		} else {
			System.out.println("No. It is not a toepliz matrix.");
		}
	}

	private static boolean checkIfItIsToeplitzMatrix(int[][] matrix) {
		for (int i = 1; i < matrix.length;i++) {
			for (int j= i ;j < matrix[i].length ; j++) {
				System.out.print(matrix[i][j] + " ");
				System.out.print(matrix[i-1][j-1] + " ");
				if (matrix[i][j] != matrix[i-1][j-1]) {
					return false;
				}
			}
			System.out.println();
		}
		return true;
	}
}
