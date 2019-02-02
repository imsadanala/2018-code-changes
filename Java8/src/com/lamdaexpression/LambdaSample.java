package com.lamdaexpression;

interface A {
	void call(int i);
}

public class LambdaSample {

	public static void main(String[] args) {
		A obj;
		obj = (i) -> {
			System.out.println("Hello:: " + i);
		};
		obj.call(8);
	}

}
