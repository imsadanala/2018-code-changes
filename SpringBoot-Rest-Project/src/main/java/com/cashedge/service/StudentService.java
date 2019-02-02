package com.cashedge.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cashedge.dao.StudentDao;
import com.cashedge.beans.Student;

@Service
public class StudentService {
	@Autowired
	@Qualifier("fakedata")
	private StudentDao studentDao;

	public Collection<Student> getAllStudents() {
		return studentDao.getStudents();
	}

	public <T> Object getStudent(int studentId) {
		Student student = studentDao.getStudent(studentId);
		if (student != null) {
			return studentDao.getStudent(studentId);
		} else {
			return "No data found for student: " + studentId;
		}

	}

	public String removeStudent(int studentId) {
		return studentDao.removeStudent(studentId);
	}

	public String updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	public String insertStudent(Student student) {
		return studentDao.insertStudent(student);
	}
}
