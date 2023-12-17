package todo.p20231205;

import java.util.*;

public class BookExe {
	//등록/목록/수정/삭제
	
	private ArrayList<Book> books;
	
	BookExe() {
		books = new ArrayList<Book>();
		books.add(new Book("B001","제목","저자","출판사",1000));
		books.add(new Book("B002","제목2","저자2","출판사2",2000));
	}
	
	boolean addBook(Book std) { //추가
		return books.add(std);
	}

	ArrayList<Book> listBook() { //조회
		return books;
	}
	
	Book searchBook(String bookTitle) { //단건조회
		for(int i=0; i < books.size();i++) {
			
		}
		return books.get(0);
	}

	boolean modBook(String no, int price) { //수정
		
		
		return false;
	}

	boolean delBook(String bookTitle) { //삭제
		
		return false;
	}
	
	
	
}
