package com.sudharsan.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Person {
	private final String name;
	private final Integer age;

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

public class StreamTutorial {

	public static void main(final String... arg) {
		final List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 23),
				new Person("Pamela", 23), new Person("David", 12));

		final List<Person> filtered = persons.stream().filter(p -> p.getName().startsWith("P"))
				.collect(Collectors.toList());

		System.out.println(filtered);

		final Map<Integer, List<Person>> groupingBy = persons.stream().collect(Collectors.groupingBy(p -> p.getAge()));

		System.out.println(groupingBy);
		
		groupingBy.forEach((age, p) -> {
			System.out.format("%d : %s ", age, p);
		});
		
		final Double averageAge = persons.stream()
				.collect(Collectors.averagingDouble(p-> p.getAge()));
		
		System.out.println(averageAge);
		
		System.out.println(persons.stream()
				.filter(p -> p.getAge() > 18)
				.map(p -> p.getName())
				.collect(Collectors.joining(",", "Hi All, ", "Cool Dude")));
		
		System.out.println(persons.stream()
				.collect(Collectors.toMap(p -> p.getAge(),
						p -> p.getName(),
						(name1, name2) -> name1 + ";" + name2)));
						
		Collector<Person, StringJoiner, String> personNameCollector = Collector.of(() -> new StringJoiner(" | ") ,
				(j, p) -> j.add(p.getName().toUpperCase()),
				(j1, j2) -> j1.merge(j2),
				StringJoiner::toString);
		
		System.out.println(persons.stream()
				.collect(personNameCollector));
		
	}
}
