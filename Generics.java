package com.sudharsan.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Generics  {

	public static <E> void iterateElements(E[] elements) {
		for (E e : elements) {
			System.out.println("Element : " + e);
		}
	}

	public static <T extends Comparable<T>> T compare(T... elements) {
		T max = elements[0];

		for (int i = 1 ; i < elements.length ; i++) {
			if (max.compareTo(elements[i]) < 0 ) {
				max = elements[i];
			}
		}
		return max;
	}
	
	static public void main(final String... args) {
		
		final Integer[] integers = {1, 2, 5, 4, 3};
		
		final Float[] floats = { 1.2f, 3.4f, 5.6f, 7.8f};
		
		final Double[] doubles = { 1.2, 3.4, 5.6, 7.8 };
		
		final Character[] characters = {'h', 'e', 'l', 'l', 'o'};
		
		iterateElements(integers);
		iterateElements(floats);
		iterateElements(doubles);
		iterateElements(characters);
		
		GenericClass<String> stringObj = new GenericClass<>();
		stringObj.add("String");
		
		GenericClass<Integer> integerObj = new GenericClass<>();
		integerObj.add(4);
		
		System.out.println(stringObj.get() + " " + integerObj.get());
		
		System.out.println(compare(integers));
		System.out.println(compare(floats));
		System.out.println(compare(doubles));
		System.out.println(compare(characters));
		
		final List<Integer> integerList = Arrays.asList(integers);
		Collections.sort(integerList, (c1, c2) -> c1.compareTo(c2));
		System.out.println(integerList);
		
		Arrays.stream(integers).max((c1, c2) -> c1.compareTo(c2));
		
	}
}

class GenericClass<T> {
	
	 T t;
	 
	 public void add(T t) {
		 this.t = t;
	 }
	 
	 public T get() {
		 return t;
	 }
}