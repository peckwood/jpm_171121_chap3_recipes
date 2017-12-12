package com.mybatis3.o3.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mybatis3.o3.domain.Student;


public interface StudentMapper {
	List<Student> findAllStudentsByNameEmail(@Param("name") String name, @Param("email")String email);
}
