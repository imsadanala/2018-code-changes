package com.cashedge.dao;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cashedge.beans.Student;

@Repository
@Qualifier("mangodata")
public class MangoDBStudentDao implements StudentDao {

	@Override
	public Collection<Student> getStudents() {
		return new ArrayList<Student>() {
			{
				add(new Student(1, "MANGO", "MANGO"));
			}
		};
	}

	@Override
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeStudent(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

}
