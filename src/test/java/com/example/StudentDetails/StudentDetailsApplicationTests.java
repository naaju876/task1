package com.example.StudentDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentDetailsApplicationTests {

	@Autowired    private service studentService;

    @Test    public void testSaveAndGetStudent() {
        Student student = new Student();
        student.setName("John Doe");
        student.setAge(25);
        student.setSalary(50000.0);

        Student savedStudent = studentService.saveStudent(student);

        assertNotNull(savedStudent.getId());        assertEquals("John Doe", savedStudent.getName());
        assertEquals(25, savedStudent.getAge());
        assertEquals(50000.0, savedStudent.getSalary());

        Long studentId = savedStudent.getId();
        Student retrievedStudent = studentService.getStudentById(studentId);

        assertNotNull(retrievedStudent);
        assertEquals(savedStudent.getName(), retrievedStudent.getName());
        assertEquals(savedStudent.getAge(), retrievedStudent.getAge());
        assertEquals(savedStudent.getSalary(), retrievedStudent.getSalary());
    }
}