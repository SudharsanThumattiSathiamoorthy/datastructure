package com.sudharsan.examples;

class Trie {
	Trie[] children;
	char c;
	boolean isLeaf;

	public Trie() {
		this.children = new Trie[26];
	}
}

public class Tries {

	private Trie root;

	public Tries() {
		this.root = new Trie();
	}

	public void insert(final String word) {
		if (word == null) {
			return;
		}

		Trie parent = this.root;
		for (int i = 0; i < word.length() ;i++) {
			char c = word.charAt(i);
			int index = c - 'a';
			
			if (parent.children[index] == null) {
				final Trie temp = new Trie();
				temp.c = c;
				parent.children[index] = temp;
				parent = temp;
			} else {
				parent = parent.children[index];
			}
		}
		parent.isLeaf = true;
	}

	public boolean search(final String input) {
		if (input == null) {
			return false;
		}
		 Trie temp = this.root;
		 for (int i =0 ; i< input.length() ;i++) {
			 char c = input.charAt(i);
			 int index = c - 'a';
			 
			 Trie next = temp.children[index];
			 if (next != null && next.c == c) {
				 temp = next;
			 } else {
				 return false;
			 }
		 }
		 return true;
	}

	static public void main(final String[] args) {
		
	}
}
