package com.cashedge.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cashedge.beans.Student;

@Repository
@Qualifier("fakedata")
public class FakeStudentDaoImp implements StudentDao {

	static Map<Integer, Student> students;
	static {
		students = new HashMap<Integer, Student>() {
			private static final long serialVersionUID = 349223244750156873L;

			{
				put(1, new Student(1, "ONE", "A"));
				put(2, new Student(2, "TWO", "B"));
				put(3, new Student(3, "THREE", "C"));
				put(4, new Student(4, "FOUR", "D"));
				put(5, new Student(5, "FIVE", "E"));
				put(6, new Student(6, "SIX", "F"));
			}
		};
	}

	public Collection<Student> getStudents() {
		return this.students.values();
	}

	public Student getStudent(int studentId) {
		return this.students.get(studentId);
	}

	public String removeStudent(int studentId) {
		this.students.remove(studentId);
		return "student:: " + studentId + " successfully removed";
	}

	public String updateStudent(Student student) {
		if (student != null) {
			Student s1 = this.students.get(student.getId());
			if (s1 != null && student != null) {
				if (!s1.getCourse().equals(student.getCourse()) || !s1.getName().equals(student.getName())
						|| s1.getId() != student.getId()) {
					s1.setCourse(student.getCourse());
					s1.setName(student.getName());
					s1.setId(student.getId());
					return "student details are updated succussfully";

				} else {
					return "Data is available but no student details are updated";
				}

			} else {
				return "no student details are updated";
			}
		} else {
			return "no student details are updated";
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cashedge.dao.StudentDao#insertStudent(com.cashedge.dao.bean.Student)
	 */
	public String insertStudent(Student student) {
		try {
			if (student != null) {
				Student s1 = this.students.get(student.getId());
				if (s1 != null && s1.getId() == student.getId()) {
					return "student details are already available";
				} else {
					System.out.println("HIii");
					this.students.put(student.getId(), student);
					return "new student is successfully inserted";
				}
			} else {
				return "no student details are updated";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String partialUpdate(Student student) {
		if (student != null) {
			int id = student.getId();
			if (id > 0) {
				Student s1 = this.students.get(id);
				if (s1 != null && student != null) {
					if (student.getCourse() != null && !s1.getCourse().equals(student.getCourse())) {
						s1.setCourse(student.getCourse());
						return "student course details are partially updated succussfully for student Id " + id;
					} else if (student.getName() != null && !s1.getName().equals(student.getName())) {
						s1.setName(student.getName());
						return "student name details are partially updated succussfully  for student Id " + id;
					} else {
						return "Data is available but no student details are updated";
					}

				} else {
					return "no student details are updated";
				}
			} else {
				return "no student details are updated";
			}
		} else {
			return "no student details are updated";
		}
	}
}
