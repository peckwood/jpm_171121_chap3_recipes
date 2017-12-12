package com.mybatis3.o5.mappers;

import java.util.List;

import com.mybatis3.o5.domain.Student;


public interface StudentMapper {
	List<Student> findAllStudents();
}
