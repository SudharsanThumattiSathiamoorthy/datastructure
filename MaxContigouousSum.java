package com.sudharsan.examples;

public class MaxContigouousSum {

	public static void main(final String[] args) {
		int arr[] = {1, -2, -3, 0, 7, -8, -2};
        System.out.println("Maximum Sub array product is "+
        		maxSum(arr));
	}

	private static int maxSum(int[] a) {
		int max = 0, max_so_far = Integer.MIN_VALUE;

		for (int i= 0; i< a.length;i++) {
			max += a[i];
			if (max_so_far < max) {
				max_so_far = max;
			}
			if (max < 0) {
				max = 0;
			}
		}
		return max_so_far;
	}
}
