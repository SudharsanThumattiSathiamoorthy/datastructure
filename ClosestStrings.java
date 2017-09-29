package com.sudharsan.examples;


public class ClosestStrings {

    public static int closestStrings(final String s1,
                                     final String s2,
                                     final int m,
                                     final int n) {
        if (m == 0) {
            return n;
        }

        if (n == 0) {
            return m;
        }

        int cost;
        if (s1.charAt(m-1) == s2.charAt(n-1)) {
            cost = 0;
        } else {
            cost = 1;
        }

        return min(closestStrings(s1, s2, m-1, n-1) + cost,
                closestStrings(s1, s2, m-1, n) + 1,
                closestStrings(s1, s2, m, n-1) + 1);
    }

    public static int min(int x, int y, int z) {
        if (x < y && x < z) {
            return x;
        } else if (y < z) {
            return y;
        }
        return z;
    }

    public static void main(final String[] args) {

    }
}
