package com.lamdaexpression;

import java.util.Arrays;
import java.util.List;

public class StreamAPISample {

	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5, 6);
		// to convert stream list , just use stream() available in the List
		asList.stream().forEach(i -> System.out.println(i));
	}

}
