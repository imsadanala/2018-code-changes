package com.lamdaexpression;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateAPISample {

	public static void main(String[] args) {
		// This is to get the Date
		LocalDate now = LocalDate.now();
		System.out.println(now);
		//This is get the LocalTime
		LocalTime now2 = LocalTime.now();
		System.out.println(now2);
		
		System.out.println(LocalTime.of(23, 12, 34));
	}
	
}
