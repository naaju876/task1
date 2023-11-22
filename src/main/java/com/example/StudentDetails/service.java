package com.example.StudentDetails;

import org.springframework.beans.factory.annotation.Autowired;

public class service {
	@Autowired    
	private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
}


