package com.java8.streams;

import static com.java8.streams.bean.Person.getPersonList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.java8.streams.bean.Gender;
import com.java8.streams.bean.Person;

/**
 * 
 * @author suresh sadanala
 *
 */
public class StreamsTest {
	public static void main(String[] args) {
		
		//List<Person> personList = getPersons();
		//personList.stream().filter(person -> person.getName().equals("A")).collect(Collectors.toList()).forEach(person -> System.out.println("ID is "+ person.getId()));;
		//personList.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);
		//personList.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);
		//Lambda expression
		//personList.forEach(a -> System.out.println(a));
		
		List<Person> personList = getPersonList();
		System.out.println("Person list "+ personList);
		
		//Get all females
		List<Person> feMalePersonList = personList.stream()
				  								  .filter(male -> male.getGender() == Gender.FEMALE)
				  								  .collect(toList());
		System.out.println("All fe-males "+ feMalePersonList);
		
		//Get the names in upper-case, names of FEMALE older than 18 
		List<String> namesList = personList.stream()
				  						   .filter(person -> person.getAge()>18)
				  						   .filter(person -> person.getGender() == Gender.FEMALE)
				  						   .map(names -> names.getName().toUpperCase())
				  						   .collect(toList());
		System.out.println("Person name list "+ namesList);
		
		//sum of female person age's
		int sum = personList.stream()
							.filter(female -> female.getGender() == Gender.FEMALE)
		          			.mapToInt(Person::getAge)
		           			.sum();
		System.out.println("Total female persons age is "+ sum);
		
		// to sort the persons by age
		List<Person> sortedPersonListByAge = personList.stream()
				  									   .sorted((person1, person2) -> person2.getAge() > person1.getAge() ? 1 : -1)
				  									   .collect(toList());
		System.out.println(" sortedPersonListByAge "+ sortedPersonListByAge);
		
		
		// get oldest person name
		Optional<String> oldestPersonName = personList.stream()
				  									  .max((person1, person2) -> person1.getAge() > person2.getAge() ? 1 : -1)
				  									  .map(Person::getName);
		System.out.println("Oldest person name is "+ (oldestPersonName.isPresent() ? oldestPersonName.get() : null));
		
		// get oldest person name
		Optional<String> youngestPersonName = personList.stream()
						  								.min((person1, person2) -> person1.getAge() > person2.getAge() ? 1 : -1)
						  								.map(Person::getName);
		System.out.println("Youngest person name is "+ (youngestPersonName.isPresent() ? youngestPersonName.get() : null));
		
		// count of non-adults
		long nonAdultsCount = personList.stream()
				  						.filter(nonAdults -> nonAdults.getAge() < 18)
				  						.count();
		System.out.println("Teanager are " + nonAdultsCount);
		

		//no duplicate females
		Set<Person> feMalePersonSet = personList.stream()
				  								.filter(male -> male.getGender() == Gender.FEMALE)
				  								.collect(toSet());
		System.out.println("All unique fe-males "+ feMalePersonSet);
		
		//map by name & age
		Map<String, List<Person>> groupByMap = personList.stream()
													  	 .collect(groupingBy(Person::getName));
		groupByMap.forEach((k, v) -> {
						System.out.println(k + " -- " + v);
					}
		);
		//find the first person whose name is 4 letter but older than 25
		Optional<Person> findFirst = personList.stream()
											   .sorted((person1, person2) -> person1.getAge() > person2.getAge() ? 1 : -1) // extract as a method 
											   .filter(person ->  person.getAge() > 25)
				  							   .filter(person -> person.getName().length() == 4)
				  							   .findFirst();
		System.out.println("first person 4 letter name and age > 25 is "+ (findFirst.isPresent() ? findFirst.get() : null));
	}
}
