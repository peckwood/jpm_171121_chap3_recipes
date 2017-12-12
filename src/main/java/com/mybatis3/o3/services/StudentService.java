package com.mybatis3.o3.services;

import java.util.List;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mybatis3.o3.domain.Student;
import com.mybatis3.o3.mappers.StudentMapper;
import com.mybatis3.o3.util.MyBatisSqlSessionFactory;

public class StudentService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	
	public List<Student> findAllStudentsByNameEmail(String name, String email) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findAllStudentsByNameEmail(name, email);
		} finally {
			sqlSession.close();
		}
	}
}
