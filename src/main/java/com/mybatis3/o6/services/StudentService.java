package com.mybatis3.o6.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mybatis3.o6.domain.Student;
import com.mybatis3.o6.mappers.StudentMapper;
import com.mybatis3.o6.util.MyBatisSqlSessionFactory;


public class StudentService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public void insertStudent(Student student){
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			studentMapper.insertStudent(student);
			sqlSession.commit();
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	public List<Student> findAllStudents() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findAllStudents();
		} finally {
			sqlSession.close();
		}
	}
}
