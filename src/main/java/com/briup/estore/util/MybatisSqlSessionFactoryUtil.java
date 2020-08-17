package com.briup.estore.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSqlSessionFactoryUtil {
	private static SqlSessionFactory factory;
	
	public static SqlSessionFactory getSqlSessionFactory() {
		if(factory==null) {
			try {
				InputStream inputStream = Resources.
						getResourceAsStream("mybatis-config.xml");
				factory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return factory;
	}
	
	//手动提交
	public static SqlSession openSession() {
		
		return openSession(false);
	}
	
	//有参数的openSession方法 参数代表是否自动提交 
	public static SqlSession openSession(boolean autocommit) {
		
		return getSqlSessionFactory().openSession(autocommit);
	}
	
	
	
	
	
}
