package com.java8.streams.bean;

import java.io.Serializable;

/**
 * 
 * @author Suresh Sadanala
 *
 */
public class Account implements Serializable {

	private static final long serialVersionUID = -2889312700032844072L;

	private int id;
	public String type;
	private double balance;
	private String city;

	public Account(int id, String type, double balance, String city) {
		super();
		this.id = id;
		this.type = type;
		this.balance = balance;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", type=" + type + ", balance=" + balance + ", city=" + city + "]";
	}
}
