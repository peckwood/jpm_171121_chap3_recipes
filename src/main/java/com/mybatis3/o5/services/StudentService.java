package com.mybatis3.o5.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mybatis3.o5.domain.Student;
import com.mybatis3.o5.mappers.StudentMapper;
import com.mybatis3.o5.util.MyBatisSqlSessionFactory;

public class StudentService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public Map<Integer, Student> findAllStudents() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		Map<Integer, Student> map = new HashMap<>();
		try {
			sqlSession.select(
					"com.mybatis3.o5.mappers.StudentMapper.findAllStudents", 
					context -> {
						Student student = (Student) context.getResultObject();
						map.put(student.getStudId(), student);
					}

					);
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return map;
		} finally {
			sqlSession.close();
		}
	}
}
