package miniPrj;

import java.sql.*;
import java.util.*;

import todo.p20231214.Book;



public class MemberDao {
	private ArrayList<Member> members;
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 연결될 url
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev"); // url,아디,비번
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	boolean login(String id, String pw) { // 로그인
		getConn();
		
		String sql = "select * from member where id=? and passwd=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if(rs.next()) {
					return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	boolean addLogin(String id, String pw) { // 계정추가
		getConn();
		String sql = "insert into member values(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setInt(3, 0);
			
			int r = psmt.executeUpdate(); // 처리된 건수 반환 ,처리가 된다면 1이 반환
			if(r==1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("중복된 아이디입니다.");
		}
		return false;
	}
	
	boolean delLogin(String id, String pw) { // 계정삭제
		getConn();
		String sql = "delete from member where id=? and passwd=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			
			int r = psmt.executeUpdate();
			if(r >0 && pw.equals(rs.getString("passwd"))) {
				return true;
			}else {
				System.out.println("삭제할 아이디,패스워드를 확인해주세요");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
