package com.cashedge.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cashedge.beans.Student;
import com.cashedge.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping
	public Collection<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	@GetMapping("/{id}")
	public <T> Object getStudent(@PathVariable("id") int studentId) {
		return studentService.getStudent(studentId);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String removeStudent(@PathVariable("id") int studentId) {
		return studentService.removeStudent(studentId);
	}
	@RequestMapping(method = RequestMethod.PUT, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public String updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	@RequestMapping(method = RequestMethod.POST, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public String saveStudent(@RequestBody Student student) {
		return studentService.insertStudent(student);

	}
}
