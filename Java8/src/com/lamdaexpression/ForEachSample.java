package com.lamdaexpression;

import java.util.Arrays;
import java.util.List;

public class ForEachSample {

	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5, 6);
		asList.forEach(i -> System.out.println(i));
	}

}
