package com.sudharsan.examples;

import java.util.LinkedList;

public class BlockingQueue<T> {
	private LinkedList<T> queue = new LinkedList<>();
	
	private int threshold = 25;
	
	public BlockingQueue(int threshold) {
		this.threshold = threshold;
	}
	
	public void enqueue(T t) throws InterruptedException {
		if (this.queue.size() == threshold) {
			wait();
		}
		
		if (this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add(t);
	}
	
	public T dequeue() throws InterruptedException {
		if (this.queue.size() == 0) {
			wait();
		}
		
		if (this.queue.size() == threshold) {
			notifyAll();
		}
		
		return this.queue.remove(0);
	}
}