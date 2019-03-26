package com.java8.streams.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Suresh Sadanala
 *
 */
public class Person implements Serializable, Comparable<Person> {

	private static final long serialVersionUID = -4013329365459857642L;
	private int id;
	private String name;
	private int age;
	private Gender gender;

	public Person() {
		super();
	}

	public Person(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Person(String name, int age, Gender gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int compareTo(Person personC) {
		return this.getName().compareTo(personC.getName());
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	public static List<Person> getPersonList(){
		return Arrays.asList(
					new Person("Jack", 2, Gender.FEMALE),
					new Person("Jill", 12, Gender.FEMALE),	
					new Person("Sara", 20, Gender.FEMALE),
					new Person("Paula", 32, Gender.FEMALE),
					new Person("Sara", 22, Gender.FEMALE),
					new Person("Jack", 72, Gender.FEMALE),
					new Person("Bob", 20, Gender.MALE),
					new Person("Paul", 32, Gender.MALE)
				);
	}
}
