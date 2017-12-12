package com.mybatis3.o6.mappers;

import java.util.List;

import com.mybatis3.o6.domain.Student;

public interface StudentMapper {
	void insertStudent(Student student);
	List<Student> findAllStudents();
}
