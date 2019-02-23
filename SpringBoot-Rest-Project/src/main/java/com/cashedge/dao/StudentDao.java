package com.cashedge.dao;

import java.util.Collection;

import com.cashedge.beans.Student;

public interface StudentDao {

	Collection<Student> getStudents();

	Student getStudent(int studentId);

	String removeStudent(int studentId);

	String updateStudent(Student student);

	String insertStudent(Student student);

	String partialUpdate(Student student);

}