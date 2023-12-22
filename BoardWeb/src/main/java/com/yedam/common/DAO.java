package com.yedam.common;

import java.sql.*;

public class DAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //연결될 url
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url,"dev","dev"); //url,아디,비번
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
