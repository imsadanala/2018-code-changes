package com.cashedge.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@DeleteMapping(value = "/{id}")
	public String removeStudent(@PathVariable("id") int studentId) {
		return studentService.removeStudent(studentId);
	}

	@PutMapping(consumes = APPLICATION_JSON_VALUE)
	public String updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

	@PostMapping(consumes = APPLICATION_JSON_VALUE)
	public String saveStudent(@RequestBody Student student) {
		return studentService.insertStudent(student);

	}

	@PatchMapping(consumes = APPLICATION_JSON_VALUE)
	public String partialUpdate(@RequestBody Student student) {
		return studentService.partialUpdate(student);
	}
}
