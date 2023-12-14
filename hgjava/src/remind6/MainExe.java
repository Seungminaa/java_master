package remind6;

import java.sql.*;

public class MainExe {
	static Connection conn;
	public static void main(String[] args) {
		//jdbc lib
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //연결될 url
		try {
			Class.forName("oracle.jdbc.OracleDriver"); //OracleDriver 있는지 확인
			conn = DriverManager.getConnection(url,"dev","dev"); //url,아디,비번
			System.out.println("연결성공");
			//select();
			String sql = "insert into student(stud_no,stud_name,eng,math) "
					+ "VALUES (?,?, ?,?)"; //파라미터 값으로 구문처리
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, "23-003"); //파라미터 값 지정
			psmt.setString(2, "박씨");
			psmt.setInt(3, 80);
			psmt.setInt(4, 85);
			
			//입력, 수정, 삭제 => executeUpdate();
			int r = psmt.executeUpdate();
			if(r==1) {
				System.out.println("입력성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Driver 없음");
		}
	}
	public static void select() throws Exception {
		String sql = "select * from student";
		PreparedStatement psmt = conn.prepareStatement(sql); //구문해석후 처리
		ResultSet rs = psmt.executeQuery(); //구문 저장,구문 불러오기
		while(rs.next()) {
			System.out.println("번호:" + rs.getString("stud_no") + ",이름:" + rs.getString("stud_name")+",영어점수:"+rs.getInt("eng")+",수학점수:"+rs.getInt("math")); //컬럼값을 가져옴
		}
	}
}
