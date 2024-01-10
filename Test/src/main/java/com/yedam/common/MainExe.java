package com.yedam.common;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class MainExe {
	public static void main(String[] args) {
		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession session = factory.openSession(true);
		
		//데이터 확인란
		
		
	}
}
