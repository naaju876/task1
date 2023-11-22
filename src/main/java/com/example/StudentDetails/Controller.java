package com.example.StudentDetails;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/student")
public class Controller {
	
	Logger log = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private service studentservice;
	@GetMapping("/Students")
	public List<Student> getAllStudent() {
		log.info("All available students are viewed");
		return studentservice.getAllStudents();
	}

	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		log.info(" student based on id is viewed");
		return studentservice.addStudent(student);
	}

	@GetMapping("/{id}")
	public Student getStudentId(@PathVariable("id") int id) {
		log.info(" New student details are added");
		return studentservice.getStudentId(id);
	}

	
	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
		log.info("student details are updated");
		return studentservice.updateStudent(id, student);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		log.info("Deleted student based on id");
		studentservice.delete(id);
	}

}
