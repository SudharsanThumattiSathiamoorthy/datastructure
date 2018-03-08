package com.sudharsan.examples;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;

public class ReadWriteLock<T> {

	private Set<T> elements;
	
	private ReentrantReadWriteLock reentrantLock = new ReentrantReadWriteLock(true);
	
	private Lock readLock;
	
	private Lock writeLock;
	
	public ReadWriteLock() {
		elements = new HashSet<>();
		
		readLock = reentrantLock.readLock();
		
		writeLock = reentrantLock.writeLock();
	}
	
	public void addElement(final Element element) {
		
		writeLock.lock();
		try {
			element.processElement(element);
		} finally {
			writeLock.unlock();
		}
	}
	
	public void readElement() {
		readLock.lock();
		try {
			elements.forEach(new Consumer<T>() {
				
			});
		} finally {
			readLock.lock();
		}
		
	}
	
	static public void main(final String... args) {
		
	}
}

interface Element {
	
	default void processElement(final Element element) {
		
	}
}