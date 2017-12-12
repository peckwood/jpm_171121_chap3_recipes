package com.mybatis3.o6.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mybatis3.o6.domain.Student;

public class StudentServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceTest.class);
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
	@Test
	public void testFindAllStudentsTwice(){
		long t1 = Calendar.getInstance().getTimeInMillis();
		
		List<Student> students = studentService.findAllStudents();
		long t2 = Calendar.getInstance().getTimeInMillis();
		logger.info("milliseconds spent in first query: {}", t2-t1);
		Assert.assertNotNull(students);
		for(Student student:students){
			System.out.println(student);
		}
		
		long t3 = Calendar.getInstance().getTimeInMillis();
		List<Student> students2 = studentService.findAllStudents();
		long t4 = Calendar.getInstance().getTimeInMillis();
		logger.info("milliseconds spent in first query: {}", t4-t3);
		Assert.assertNotNull(students2);
		for(Student student2:students2){
			System.out.println(student2);
		}
		
		
	}
}
