package com.sudharsan.examples;

public class GeneratePermutationOfNos {

    public static void generate(int[] a, int i, int n) {
        if (n ==0) {
            printArray(a, i);
        } else if (n > 0) {
            for (int k =1;k <= n;k++) {
                a[i] = k;
                generate(a, i+1, n-k);
            }
        }
    }

    private static void printArray(int[] a, int n) {
        for (int i = 0;i < n;i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static void main(final String[] args) {
        int a[] = new int[100];
        generate(a, 0, 5);
    }
}
