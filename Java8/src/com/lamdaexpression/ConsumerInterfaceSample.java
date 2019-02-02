package com.lamdaexpression;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaceSample {

	public static void main(String[] args) {

		Consumer<Integer> consumer = new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.println(t);
			}
		};
		List<Integer> asList = Arrays.asList(1,2,3,4,5,6,7,8);
		asList.forEach(consumer);
	}
}
