package com.sudharsan.examples;

import java.util.Objects;
import java.util.Stack;

class Node {
	char data;
	Node left;
	Node right;
	
	Node (char data) {
		this.data = data;
	}
}
public class PostFixToInFix {
	
	static boolean isOperator(char c) {
		switch(c) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '^':
			return true;
		}
		return false;
	}
	
	static Node constructInFixTree(char a[]) {
		final Stack<Node> s = new Stack<>();
		
		for (int i=0; i < a.length; i++) {
			if (!isOperator(a[i])) {
				final Node node = new Node(a[i]);
				s.push(node);
			} else {
				final Node node1 = s.pop();
				final Node node2 = s.pop();
				
				final Node node = new Node(a[i]);
				node.right = node1;
				node.left = node2;
				
				s.push(node);
			}
		}
		return s.pop();
	}
	
	static void inorder(Node node) {
		if (Objects.isNull(node)) {
			return;
		}
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}

	static public void main(final String arg[]) {
		char a[] = {'a', 'b', '+', 'e', 'f', '*', 'g', '*', '-' };
		final Node node = constructInFixTree(a);
		inorder(node);
	}
}
