package com.yedam;

import java.sql.*;
import java.util.ArrayList;


public class BoardDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private MemberDAO mdao = new MemberDAO();
	
	
	ArrayList<Board> boardList() {
		conn = mdao.getConn();
		ArrayList<Board> boards = new ArrayList<Board>();
		String sql = "select * from board order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBNum(rs.getInt("b_num"));
				board.setBName(rs.getString("b_name"));
				board.setBTitle(rs.getString("b_title"));
				board.setBContent(rs.getString("b_content"));
				board.setBDate(rs.getDate("b_date"));
				// 배열의 빈곳에 한건 저장
				boards.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boards;
		
	}

}
