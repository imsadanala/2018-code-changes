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

	public String partialUpdate(Student student) {
		if (student != null) {
			String course = student.getCourse();
			int id = student.getId();
			String name = student.getName();
			if(id < 0) {
				return "unable to do partial update for this request";
			}
			if ((id > 0 && course != null && course.length() > 0) || (name != null && name.length() > 0 && id > 0))
			{
				return studentDao.partialUpdate(student);
			}
		}
		return "unable to do partial update for this request";
	}
}
