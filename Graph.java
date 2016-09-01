package com.sudharsan.examples;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Graph {

	private int vertices;
	private List<Integer> adjacancyList[];
	
	Graph(int vertices) {
		this.vertices = vertices;
		adjacancyList = new LinkedList[this.vertices];
		
		for (int i = 0; i < vertices;i++) {
			adjacancyList[i] = new LinkedList<>();
		}
	}
	
	void addEdge(int v, int w) {
		adjacancyList[v].add(w);
	}
	
	void BFS(int s) {
		final boolean flag[] = new boolean[this.vertices];

		final LinkedList<Integer> queue = new LinkedList<>();
		flag[s] = true;
		queue.add(s);
		
		while(!queue.isEmpty()) {
			int element = queue.poll();
			System.out.print(element + " ");
			
			for (final Integer integer : adjacancyList[element]) {
				if (!flag[integer]) {
					flag[integer] = true;
					queue.add(integer);
				}
			}
		}
	}
	
	private void DFS(int node, boolean[] visited, Stack<Integer> stack) {
		if (visited[node]) {
			return;
		}

		visited[node] = true;
		stack.add(node);
		
		while(!stack.isEmpty()) {
			int element = stack.pop();
			System.out.print(element + " ");
			
			for (Integer integer : adjacancyList[node]) {
				DFS(integer, visited, stack);
			}
		}
	}

	public static void main(final String[] args) {
		final Graph g = new Graph(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.BFS(2);
        
        System.out.println();
        g.DFS(2, new boolean[4], new Stack<Integer>());
	}
}
