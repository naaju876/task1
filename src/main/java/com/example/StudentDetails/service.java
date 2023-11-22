package com.example.StudentDetails;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public interface service {
	

		public List<Student> getAllStudents();
		public Student addStudent(Student student);
		public Student getStudentId(int id);
	 
		public Student updateStudent(int id, Student student);
	 
		public void delete(int id);
	 
		
}
	        