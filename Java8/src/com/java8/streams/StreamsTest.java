package com.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.java8.streams.bean.Person;

public class StreamsTest {
	public static void main(String[] args) {
		List<Person> personList = getPersons();
		//personList.stream().filter(person -> person.getName().equals("A")).collect(Collectors.toList()).forEach(person -> System.out.println("ID is "+ person.getId()));;
		//personList.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);
		personList.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);
		
		//personList.forEach(a -> System.out.println(a));
	}
	private static List<Person> getPersons() {
		return Arrays.asList(new Person(1, "E", 71), new Person(2, "D", 19), new Person(3, "C", 13),
				new Person(4, "B", 100), new Person(5, "A", 54));
	}

}
