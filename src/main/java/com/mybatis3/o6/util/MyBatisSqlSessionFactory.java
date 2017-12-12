package com.mybatis3.o6.util;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;


public class MyBatisSqlSessionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSession openSession(){
		return getSqlSessionFactory().openSession();
	}
	
	public static SqlSessionFactory getSqlSessionFactory(){
		if(sqlSessionFactory==null){
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(getConfiguration());
		}
		return sqlSessionFactory;
	}
	
	public static Configuration getConfiguration(){
		Configuration configuration = new Configuration(getEnvironment());
		configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);
		configuration.getTypeAliasRegistry().registerAliases("com.mybatis3.o6.domain");
		
		//Mappers should be added to the confguration only after registering
		//typeAliases and typeHandlers if they have been used.
		configuration.addMappers("com.mybatis3.o6.mappers");
		return configuration;
	}
	
	public static Environment getEnvironment(){
		DataSource dataSource = MyDataSourceFactory.getDataSourceFromPropertiesFile();
		TransactionFactory jdbcTranactionFactory = new JdbcTransactionFactory();
		Environment env = new Environment("development", jdbcTranactionFactory, dataSource);
		return env;
	}
	
	
	
}
