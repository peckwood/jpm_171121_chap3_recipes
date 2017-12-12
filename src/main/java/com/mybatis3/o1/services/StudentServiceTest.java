package com.mybatis3.o1.services;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mybatis3.o1.domain.Gender;
import com.mybatis3.o1.domain.Student;

public class StudentServiceTest {
	private static StudentService studentService;
	
	@BeforeClass
	public static void setup(){
		studentService = new StudentService();
	}
	
	@AfterClass
	public static void teardown(){
		studentService = null;
	}

	@Test
	public void testInsertStudent(){
		Student studentToInsert = new Student();
		studentToInsert.setDob(new Date());
		studentToInsert.setEmail("a@b.com");
		studentToInsert.setGender(Gender.MALE);
		studentToInsert.setName("Raiden12");
		studentService.insertStudent(studentToInsert);
		
		List<Student> students = studentService.findAllStudents();
		for(Student student:students){
			System.out.println(student);
		}
	}
	
	@Test
	public void testFindAllStudents(){
		List<Student> students = studentService.findAllStudents();
		Assert.assertNotNull(students);
		for(Student student:students){
			System.out.println(student);
		}
	}
}
