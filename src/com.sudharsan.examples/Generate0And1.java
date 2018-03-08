package com.sudharsan.examples;

import java.util.Arrays;

public class Generate0And1 {

    public static void generate(int a[], int n) {
        if (n <= 0) {
            System.out.println(Arrays.toString(a));
        } else {
            a[n-1] = 0;
            generate(a, n-1);
            a[n-1] = 1;
            generate(a, n-1);
        }
    }

    public static void main(final String[] args) {
        int a[] = new int[3];
        generate(a, 3);
    }
}
