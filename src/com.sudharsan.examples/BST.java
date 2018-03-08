package com.sudharsan.examples;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

class BinarySearchTree {
	int data;
	BinarySearchTree left;
	BinarySearchTree right;
	
	BinarySearchTree (int data) {
		this.data = data;
	}
}
public class BST {

	public static BinarySearchTree insert(BinarySearchTree node, int data) {
		if (node == null) {
			BinarySearchTree temp = new BinarySearchTree(data);
			return temp;
		}
		else if (data < node.data) {
			node.left = insert(node.left, data);
		} else if (data > node.data) {
			node.right = insert(node.right, data);
		}
		return node;
	}
	
	public static void preorder(BinarySearchTree node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}
	
	public static void inorder(BinarySearchTree node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}
	
	public static void minDepth(BinarySearchTree node, int level, AtomicInteger min) {
		if (node == null) {
			return;
		}
		if (level < min.get()) {
			min.set(level);
		}
		minDepth(node.left, level -1, min );
		minDepth(node.right, level + 1, min);
	}
	
	public static void maxDepth(BinarySearchTree node, int level, AtomicInteger max) {
		if (node == null) {
			return;
		}
		if (level > max.get()) {
			max.set(level);
		}
		maxDepth(node.left, level -1 , max);
		maxDepth(node.right, level +1, max);
	}

	public static void printNodeForLevels(BinarySearchTree node, int currentLevel, int targetLevel) {
		if (node == null) {
			return;
		}
		if (currentLevel == targetLevel) {
			System.out.print(node.data + " ");
		}
		printNodeForLevels(node.left, currentLevel - 1, targetLevel);
		printNodeForLevels(node.right, currentLevel + 1, targetLevel);
	}
	
	public static int height(BinarySearchTree node) {
		if (node == null) {
			return 0;
		}
		return max(height(node.left) + 1, height(node.right) + 1);
	}
	
	private static int max(int i, int j) {
		return i > j ? i : j;
	}

	public static void bfs(final BinarySearchTree node) {
		if (node == null) {
			return;
		}

		final LinkedList<BinarySearchTree> queue = new LinkedList<>();
		queue.add(node);

		while(!queue.isEmpty()) {
			final BinarySearchTree bst = queue.poll();
			if (bst != null) {
				System.out.print(bst.data + " ");

				queue.add(bst.left);
				queue.add(bst.right);
			}
		}
	}

	public static void dfs(final BinarySearchTree node) {
		if (node == null) {
			return;
		}

		final Stack<BinarySearchTree> stack = new Stack<>();
		stack.add(node);

		while (!stack.isEmpty()) {
			final BinarySearchTree bst = stack.pop();
			if (bst != null) {
				System.out.print(bst.data + " ");

				stack.add(bst.right);
				stack.add(bst.left);
			}
		}
	}

	static public void main(final String[] arg) {
		BinarySearchTree node = insert(null, 5);
		node = insert(node, 2);
		node = insert(node, 12);
		node = insert(node, -4);
		node = insert(node, 3);
		node = insert(node, 9);
		node = insert(node, 21);
		node = insert(node, 19);
		node = insert(node, 25);

		// In-Order traversal.
		System.out.print("\n In-Order traversal : ");
		inorder(node);
		System.out.println();

		// Pre-Order traversal.
		System.out.println("\n Pre-Order traversal : ");
		preorder(node);
		System.out.println();

		// Finding the min and max depth.
		final AtomicInteger min = new AtomicInteger(0);
		minDepth(node, 0, min);
		int minDepth = min.get();

		final AtomicInteger max = new AtomicInteger(0);
		maxDepth(node, 0, max);
		int maxDepth = max.get();

		System.out.println("minDepth : " + minDepth);
		System.out.println("maxDepth : " + maxDepth);

		// Print node in vertical order.
		for (int i = minDepth ; i <= maxDepth ; i++) {
			printNodeForLevels(node, 0, i);
		}

		// Height of the BST.
		System.out.println("\n Height : " + height(node));

		// Breadth First Search.
		System.out.println("\n BFS Traversal : ");
		bfs(node);

		// Depth First search.
		System.out.println("\n DFS Traversal : ");
		dfs(node);

		// Top view of the tree.
		System.out.println("\n Top View : ");
		final Map<Integer, Boolean> map = new HashMap<>();
		for (int i = minDepth ;i <= maxDepth ;i++) {
			topView(node, 0, i, map);
		}
		
		// Find nth largest element in BST.
		final AtomicInteger targetNo = new AtomicInteger(1);
		findNthLargestElement(node, targetNo, 3);
	}

	private static void findNthLargestElement(final BinarySearchTree node, final AtomicInteger targetNo, final int i) {
		if (node == null) {
			return;
		}
		findNthLargestElement(node.left, targetNo, i);
		if (targetNo.get() == i) {
			targetNo.incrementAndGet();
			System.out.println("\n Target no is  : " + node.data);
			return;
		} else {
			targetNo.incrementAndGet();
		}
		findNthLargestElement(node.right, targetNo, i);
	}

	private static void topView(final BinarySearchTree node,
			final int currentLevel,
			final int targetLevel,
			final Map<Integer, Boolean> map) {
		if (node == null) {
			return;
		}

		if (currentLevel == targetLevel && map.get(targetLevel) == null) {
			System.out.print(node.data + " ");
			map.put(targetLevel, true);
		}
		topView(node.left, currentLevel - 1 , targetLevel, map);
		topView(node.right, currentLevel + 1 , targetLevel, map);
	}
}
