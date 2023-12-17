package todo.p20231205;

import lombok.Data;

@Data
public class Book {
	// 도서코드 /도서명 /저자 / 출판사 / 가격정보 저장
	private String bookCode;
	private String bookTitle;
	private String author;
	private String press;
	private int price;

	Book() {

	}

	public Book(String bookCode, String bookTitle, String author, String press, int price) {
		this.bookCode = bookCode;
		this.bookTitle = bookTitle;
		this.author = author;
		this.press = press;
		this.price = price;
	}

	void showInfo() {
		System.out.println(this.bookCode + " " + this.bookTitle + " "+ this.author + " " + this.press + " " + this.price);
	}
}
