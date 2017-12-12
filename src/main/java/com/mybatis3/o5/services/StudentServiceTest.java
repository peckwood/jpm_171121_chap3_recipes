package com.mybatis3.o5.services;

import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mybatis3.o5.domain.Student;

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
	public void testFindAllStudents(){
		Map<Integer, Student> students = studentService.findAllStudents();
		Assert.assertNotNull(students);
		System.out.println(students);
	}
}
