package com.yedam;

import java.sql.*;
import java.util.ArrayList;


public class BoardDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private MemberDAO mdao = new MemberDAO();
	private ArrayList<Board> boards;
	private int count;
	
	
	ArrayList<Board> boardList() { //글 리스트 보기
		conn = mdao.getConn();
		boards = new ArrayList<Board>();
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
				board.setBDate(rs.getString("b_date"));
				// 배열의 빈곳에 한건 저장
				boards.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			mdao.disConn();
		}
		return boards;
		
	}


	boolean boardAdd(String id,String bTitle,String bContent) { //글 등록
		conn = mdao.getConn();
		String sql = "select nvl(MAX(b_num),1) as count from board";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1)+1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sql = "insert into board values(?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			Board board = new Board(bTitle,bContent);
			psmt.setInt(1, count);
			psmt.setString(2, id);
			psmt.setString(3, bTitle);
			psmt.setString(4, bContent);
			psmt.setString(5, board.getBDate());
			
			int r = psmt.executeUpdate();
			if(r==1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			mdao.disConn();
		}
		
		return false;
	}


	boolean boardMod(String id,int boardDetail, String bTitle, String bContent) { //글 수정
		conn = mdao.getConn();
		String sql = "update board set b_title=?,b_content=? where b_num=? and b_name=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bTitle);
			psmt.setString(2, bContent);
			psmt.setInt(3, boardDetail);
			psmt.setString(4, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			return false;
//			e.printStackTrace();
		}finally {
			mdao.disConn();
		}
		return false;
	}


	Board bDetailView(int boardDetail) {
		conn = mdao.getConn();
		String sql = "select * from board where b_num=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardDetail);
			rs = psmt.executeQuery();
			if(rs.next()) {
				Board board = new Board();
				board.setBNum(rs.getInt("b_num"));
				board.setBName(rs.getString("b_name"));
				board.setBTitle(rs.getString("b_title"));
				board.setBContent(rs.getString("b_content"));
				board.setBDate(rs.getString("b_date"));
				return board;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			mdao.disConn();
		}
		return null;
	}


	boolean boardDel(String id, int boardDetail) {
		conn = mdao.getConn();
		String sql = "delete from board where b_num=? and b_name=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardDetail);
			psmt.setString(2, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			return false;
//			e.printStackTrace();
		}finally {
			mdao.disConn();
		}
		return false;
	}
	

	

}
