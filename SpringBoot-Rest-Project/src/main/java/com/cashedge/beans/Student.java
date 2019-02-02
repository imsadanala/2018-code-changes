package com.cashedge.beans;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1205812818838475127L;
	private int id;
	private String name;
	private String course;

	public Student() {

	}

	public Student(int id, String name, String course) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

}
