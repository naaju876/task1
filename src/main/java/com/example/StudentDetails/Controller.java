package com.example.StudentDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class Controller {

	@Autowired

	private service studentservice;

	@GetMapping("/Students")

	public List<Student> getAllStudent() {

		return studentservice.getAllStudents();

	}

	@PostMapping("/add")

	public Student addStudent(@RequestBody Student student) {

		return studentservice.addStudent(student);

	}

	@GetMapping("/{id}")

	public Student getStudentId(@PathVariable("id") int id) {

		return studentservice.getStudentId(id);

	}

	@PutMapping("/update/{id}")

	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {

		return studentservice.updateStudent(id, student);

	}

	@DeleteMapping("/delete/{id}")

	public void delete(@PathVariable("id") int id) {

		studentservice.delete(id);

	}

}
