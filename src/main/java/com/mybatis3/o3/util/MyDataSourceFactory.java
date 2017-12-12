package com.mybatis3.o3.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;

public class MyDataSourceFactory {
	
	private static final Properties PROPERTIES = new Properties();
	static{
		System.out.println("loading properties from properties file");
		try {
			InputStream is = MyDataSourceFactory.class.getResourceAsStream("/db.properties");
			PROPERTIES.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("loaded properties from properties file");
	}
	public static DataSource getDataSource(){
		String url = "jdbc:mysql://localhost:3307/jpm_171113_mybatis_demo";
		String driver = "com.mysql.jdbc.Driver";
		String username = "root";
		String password = "root";
		PooledDataSource dataSource = new PooledDataSource(driver, url, username, password);
		return dataSource;
	}
	
	public static DataSource getDataSourceFromPropertiesFile(){
		PooledDataSource dataSource = new PooledDataSource(
				PROPERTIES.getProperty("driver"), //
				PROPERTIES.getProperty("url"), //
				PROPERTIES.getProperty("username"), //
				PROPERTIES.getProperty("password"));//
		return dataSource;
	}
}
