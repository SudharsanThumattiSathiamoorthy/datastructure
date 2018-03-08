package com.sudharsan.examples;

import java.util.ArrayList;
import java.util.List;

class Producer implements Runnable {

	private List<Integer> queue;
	private int threshold;

	public Producer(final List<Integer> queue, int threshold) {
		this.queue = queue;
		this.threshold = threshold;
	}

	@Override
	public void run() {
		for (int i = 0; i <= threshold; i++) {
			try {
				produce(i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
	}

	private void produce(int i) throws InterruptedException {
		synchronized (this.queue) {
			if (this.queue.size() == threshold) {
				System.out.println("Queue is full .. Wait for some time.." + Thread.currentThread().getName());
				this.queue.wait();
			}
			
			if (this.queue.size() == 0) {
				this.queue.notifyAll();
			}
			System.out.println("Added element in queue: " + i);
			this.queue.add(i);
		}
	}
}

class Consumer implements Runnable {

	private List<Integer> queue;
	private int threshold;
	
	Consumer(final List<Integer> queue, final int threshold) {
		this.queue = queue;
		this.threshold = threshold;
	}

	@Override
	public void run() {
		for (int i = 0; i< threshold;i++) {
			try {
				consume();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void consume() throws InterruptedException {
		synchronized (this.queue) {
			if (this.queue.size() == 0) {
				System.out.println("Queue is empty... wait for some time..  "  + Thread.currentThread().getName());
				this.queue.wait();
			}
			if (this.queue.size() == threshold) {
				this.queue.notifyAll();
			}
			
			System.out.println("Removed element from queue : " + this.queue.remove(0));
		}
	}
}
public class ProducerConsumer {

	static public void main(final String[] args) {
		final List<Integer> list = new ArrayList<>();
		
		final Producer producer = new Producer(list, 20);
		final Consumer consumer = new Consumer(list, 20);
		
		final Thread producerThread = new Thread(producer, "Producer");
		final Thread consumerThread = new Thread(consumer, "Consimer");
		
		producerThread.start();
		consumerThread.start();
	}
}
