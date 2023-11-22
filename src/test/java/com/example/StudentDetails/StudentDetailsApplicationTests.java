package com.example.StudentDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;



@SpringBootTest
class StudentDetailsApplicationTests {


//	    @Autowired
//		private service Service;
//		@MockBean
//		private StudentRepository studentRepository;
//		@Test
//		public void getAllStudentTest()
//		{
//			when(studentRepository.findAll()).thenReturn(Stream.of(new Student(1, "naaju", 56, 70000L)).collect(Collectors.toList()));	
//			assertEquals(1,Service.getAllStudents().size());
//		}
//}

	 
	    @Test
	    public void testGetAllStudent() {
	        List<Student> mockStudentList = Arrays.asList(new Student(1, "naaju", 56, 70000L), new Student(2, "Alice", 78, 60000));
	        when(studentService.getAllStudents()).thenReturn(mockStudentList);
	        List<Student> result = controller.getAllStudent();
	 	        assertEquals(mockStudentList, result);
	    }
	 
	    @Test
	    public void testAddStudent() {
	        Student studentToAdd = new Student(3, "aaa", 66, 50000L);
	        when(studentService.addStudent(studentToAdd)).thenReturn(studentToAdd);
	        Student result = controller.addStudent(studentToAdd);
	        assertEquals(studentToAdd, result);
	    }
	 
	    @Test
	    public void testGetStudentById() {
	        int studentId = 1;
	        Student mockStudent = new Student(studentId, "John");
	        when(studentService.getStudentId(studentId)).thenReturn(mockStudent);
	        Student result = controller.getStudentId(studentId);
	        assertEquals(mockStudent, result);
	    }
	    
	 
	    @Test
	    public void testUpdateStudent() {
	        int studentId = 1;
	        Student updatedStudent = new Student(studentId, "UpdatedJohn");
	        when(studentService.updateStudent(studentId, updatedStudent)).thenReturn(updatedStudent);
		        Student result = controller.updateStudent(studentId, updatedStudent);
	        assertEquals(updatedStudent, result);

	    }
	 
	    @Test
	    public void testDeleteStudent() {
	        int studentId = 1;
	        controller.delete(studentId);
	        ((Controller) verify(studentService, times(1))).delete(studentId);

	    }

	}
