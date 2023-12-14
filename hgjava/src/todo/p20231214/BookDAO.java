package todo.p20231214;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import remind6.Student;

public class BookDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 연결될 url
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev"); // url,아디,비번
			System.out.println("연결성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}


	boolean addBook(Book std) { // 추가
		getConn();
		String sql = "insert into book values(?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getBookCode());
			psmt.setString(2, std.getBookTitle());
			psmt.setString(3, std.getAuthor());
			psmt.setString(4, std.getPress());
			psmt.setInt(5, std.getPrice());
			
			int r = psmt.executeUpdate(); // 처리된 건수 반환 ,처리가 된다면 1이 반환
			if(r==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	ArrayList<Book> listBook() { // 조회
		getConn();
		ArrayList<Book> books = new ArrayList<Book>();
		String sql = "select * from book order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setBookCode(rs.getString("book_code"));
				book.setBookTitle(rs.getString("book_title"));
				book.setAuthor(rs.getString("author"));
				book.setPress(rs.getString("press"));
				book.setPrice(rs.getInt("price"));
				// 배열의 빈곳에 한건 저장
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	Book searchBook(String bookTitle) { // 단건조회
		getConn();
		String sql = "select * from book where book_title=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookTitle);
			rs = psmt.executeQuery();
			if(rs.next()) {
				Book book = new Book();
				book.setBookCode(rs.getString("book_code"));
				book.setBookTitle(rs.getString("book_title"));
				book.setAuthor(rs.getString("author"));
				book.setPress(rs.getString("press"));
				book.setPrice(rs.getInt("price"));
				return book;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	boolean modBook(String bookTitle, int price) { // 수정
		getConn();
		String sql = "update book "
				+ "set price=? "
				+ "where book_title=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, price);
			psmt.setString(2, bookTitle);
			int r = psmt.executeUpdate();
			
			if(r > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	boolean delBook(String bookTitle) { // 삭제
		getConn();
		String sql = "delete from book where book_title=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookTitle);
			
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
