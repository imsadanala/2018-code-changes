package com.java8.streams.collect;

import static java.util.stream.Collectors.toList;

import java.util.Comparator;

import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import com.java8.streams.bean.Account;

/**
 * 
 * @author Suresh Sadanala
 *
 */
public class CollectTest {
	public static void main(String[] args) {
		
		//List of all checking account's account id
		List<Integer> checkingsAccountList = getAccounts().filter(checkAcc -> "Checkings".equals(checkAcc.getType()))
													  	  .map(Account::getId)
													      .collect(toList());
		
		System.out.println(checkingsAccountList);
		
		//to get distinct cities
		List<String> distinctCities = getAccounts().map(Account::getCity)
											   	   .distinct()
											       .collect(toList());
		System.out.println(distinctCities);
		
		//sum of checking account balances
		Double checkingsAccBalSum = getAccounts().filter(checkAcc -> "Checkings".equals(checkAcc.getType()))
												 .collect(summingDouble(Account::getBalance));
		System.out.println(checkingsAccBalSum);
		
		//max account bal
		Optional<Account> maxAccountBal = getAccounts().collect(maxBy(Comparator.comparing(Account::getBalance)));
		System.out.println(maxAccountBal.get());
		
		//min account bal
		Optional<Account> minAccountBal = getAccounts().collect(minBy(Comparator.comparing(Account::getBalance)));
		System.out.println(minAccountBal.get());
		
		//group accounts by type and sum of their balances
		Map<String, Double> collect = getAccounts().collect(groupingBy(Account::getType, summingDouble(Account::getBalance)));
		System.out.println(collect);
		
		//group accounts by type and then further their cities and sum of their balances
		Map<String, Map<String, Double>> collect2 = getAccounts().collect(groupingBy(Account::getType, groupingBy(Account::getCity, summingDouble(Account::getBalance))));
		System.out.println(collect2);
		
		//partitioning by accounts with low and high balances
		Map<Boolean, List<Account>> collect3 = getAccounts().collect(partitioningBy(acc -> acc.getBalance() > 125));
		System.out.println(collect3);
		
		
	}
	private static Stream<Account> getAccounts() {
		return Stream.of(new Account(1, "Checkings", 100, "New York"), new Account(2, "Savings", 250, "New York"),
					new Account(3, "Checkings", 300, "New York"), new Account(4, "Checkings", 150, "Las Vegas"));
	}
	
	
}
