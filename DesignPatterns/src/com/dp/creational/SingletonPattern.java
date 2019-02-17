package com.dp.creational;

/**
 * @author Suresh Sadanala
 *
 */
public class SingletonPattern {

	static SingletonPattern singletonObject = new SingletonPattern();// Early instantiation 

	private SingletonPattern() {
	}

	public static SingletonPattern getSingletonObject() {
		return singletonObject;
	} 
	
	public static void main(String[] args) {
		SingletonPattern object1 = getSingletonObject(); // same object is assigned
		SingletonPattern object2 = getSingletonObject(); // same object is assigned
		SingletonPattern object3 = new SingletonPattern(); // different object is assigned
		if(object1 == object2) {
			System.out.println(" Hashcodes are equal hence same object is assigned to both the references");
		}
		if(object3 != object2) {
			System.out.println(" Hashcodes are not equal hence objects are distinct");
		}
		
		
	}

}
