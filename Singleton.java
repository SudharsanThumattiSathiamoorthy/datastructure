package com.sudharsan.examples;

public class Singleton {

	private Singleton() {
		
	}
	
	public static class LazyHolder {
		private static final Singleton singleton = new Singleton();
		
		public static Singleton getInstance() {
			return singleton;
		}
	}
}
