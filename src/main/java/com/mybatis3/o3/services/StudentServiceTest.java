package com.mybatis3.o3.services;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mybatis3.o3.domain.Student;

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
	public void testFindAllStudentsByNameEmail(){
		String name = "Timothy";
		String email = "timothy@gmail.com";
		List<Student> students = studentService.findAllStudentsByNameEmail(name, email);
		Assert.assertNotNull(students);
		for(Student student:students){
			System.out.println("student: "+student);
		}
	}
}
