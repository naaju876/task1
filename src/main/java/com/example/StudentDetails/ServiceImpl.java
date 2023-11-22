package com.example.StudentDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

	public class ServiceImpl implements service {

		@Autowired
		StudentRepository studentrepository;

		@Override
		public List<Student> getAllStudents() {
			return studentrepository.findAll();			
		}

		@Override
		public Student addStudent(Student student) {
			return studentrepository.insert(student);
			
		}

		@Override
		public Student getStudentId(int id) {
			return studentrepository.findById(id).get();
			
		}

		@Override
		public Student updateStudent(int id, Student student) {
			java.util.Optional<Student> findById = studentrepository.findById(id);
				          if(findById.isPresent()) {
				        	  studentrepository.save(student);
			
				          }
			
						return student;
			
					}

		@Override
		public void delete(int id) {
			studentrepository.deleteById(id);
			
		}
}
		
		
	 
