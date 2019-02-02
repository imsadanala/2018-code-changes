package com.lamdaexpression;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceSample {

	public static void main(String[] args) {
		List<String> asList = Arrays.asList("ONE", "TWO", "THREE", "FOUR");
		// call by METHOD REFERENCE
		asList.forEach(System.out::println);
	}

}
