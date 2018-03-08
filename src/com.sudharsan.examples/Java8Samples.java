package com.sudharsan.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;


public class Java8Samples {

	static public void main(final String... args) {
		
		final List<Person> listOfPersons = new ArrayList<>();
		
		listOfPersons.add(new Person("a", 1));
		listOfPersons.add(new Person("b", 2));
		listOfPersons.add(new Person("c", 3));
		listOfPersons.add(new Person("d", 4));
		
		List<Integer> ageList = listOfPersons.stream().map(p -> p.getAge()).collect(Collectors.toList());
		System.out.println(ageList);
		
		ageList.forEach(age -> {
			
		});
		StringJoiner sj = new StringJoiner(",", "ACCOUNTID IN (", ")");
		 sj.add(0).add("Sally").add("Fred");
		 System.out.println(sj.toString());
	}
}
