package com.sudharsan.examples;

import java.util.Stack;

public class InfixToPostfix {

    public static boolean isOperand(final char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A'&& c <= 'Z')) {
            return true;
        }
        return false;
    }

    public static int precedence(final char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    public static boolean isOperator(final char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
            return true;
        }
        return false;
    }

    public static void infixToPostfix(final char[] a) {

        final Stack<Character> stack = new Stack<>();

        for (int i = 0; i < a.length;i++) {
            final char c = a[i];
            if (c == '(') {
                stack.push(c);
            }
            else if (isOperand(c)) {
                System.out.print(c);
            }
            else if (c == ')') {
                while (stack.peek() != '(') {
                    System.out.print(stack.pop());
                }
                stack.pop();
            } else {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    final char ch = stack.peek();
                    while (!stack.isEmpty() && precedence(c) <= precedence(ch)) {
                        System.out.print(stack.pop());
                    }
                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
    public static void main(final String[] args) {

        final String s1 = "a+b*c";
        final String s2 = "a*(b+c)";

        infixToPostfix(s1.toCharArray());
        System.out.println();
        infixToPostfix(s2.toCharArray());
    }
}
