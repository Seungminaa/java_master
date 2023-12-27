package com.yedam.student.mapper;
//저장공간:Oracle DB

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.yedam.student.vo.Student;

//추가,수정,삭제,목록,단건조회
public class StudentDAO {
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
	//목록
	public List<Student> getStudentList() {
		getConn();
		List<Student> students = new ArrayList<Student>();
		String sql = "select * from student order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				student.setStudNo(rs.getString("stud_no"));
				student.setName(rs.getString("name"));
				student.setEng(rs.getInt("eng"));
				student.setMath(rs.getInt("math"));
				
				students.add(student);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	} //end 
	//추가
	public boolean addStudent(Student std) {
		getConn();
		String sql = "insert into student values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStudNo());
			psmt.setString(2, std.getName());
			psmt.setInt(3, std.getEng());
			psmt.setInt(4, std.getMath());
			
			int r = psmt.executeUpdate(); // 처리된 건수 반환 ,처리가 된다면 1이 반환
			if(r==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//단건조회
	public Student getStudent(String no) {
			getConn();
			String sql = "select * from student where stud_no=?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, no);
				rs = psmt.executeQuery();
				if(rs.next()) {
					Student student = new Student();
					student.setStudNo(rs.getString("stud_no"));
					student.setName(rs.getString("name"));
					student.setEng(rs.getInt("eng"));
					student.setMath(rs.getInt("math"));
					return student;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null; //조회된 값이 없으면 null 반환
		}
	//수정
	public boolean modify(String no, int eng, int mat) {
			getConn();
			String sql = "update student "
					+ "set eng=?,math=? "
					+ "where stud_no=?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, eng);
				psmt.setInt(2, mat);
				psmt.setString(3, no);
				int r = psmt.executeUpdate();
				
				if(r > 0) {
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
	//삭제
	public boolean remove(String name) {	
			getConn();
			String sql = "delete from student where name=?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, name);
				
				int r = psmt.executeUpdate();
				if(r >0) {
					return true;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
}
