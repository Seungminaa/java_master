package todo.p20231205;

import java.util.*;

public class BookApp {
	static Scanner sc = new Scanner(System.in);
	static BookExe exe = new BookExe();
	public static void main(String[] args) {
		boolean run = true;
		
		while(run) {
			System.out.println("1.등록 2.목록 3.단건조회 4.수정 5.삭제 6.종료");
			System.out.print("입력 > ");
			int menu = sc.nextInt();
			
		switch (menu) {
		case 1://등록
			System.out.print("책번호 > ");
			String bookCode = sc.next();
			System.out.print("책제목 > ");			
			String bookTitle = sc.next();
			System.out.print("저자 > ");			
			String author = sc.next();
			System.out.print("출판사 > ");			
			String press = sc.next();
			System.out.print("가격 > ");			
			int price = sc.nextInt();
			
			Book std = new Book(bookCode,bookTitle,author,press,price);
			exe.addBook(std);
			break;
			
		case 2://목록
			for(Book b : exe.listBook()) {
				b.showInfo();
			}
			break;
			
		case 3://단건조회
			System.out.println("찾을 책제목 > ");
			bookTitle = sc.next();
			exe.searchBook(bookTitle);
			break;
			
		case 4://수정
			System.out.print("수정할 책제목 > ");
			bookTitle = sc.next();
			System.out.print("수정할 가격 > ");
			price = sc.nextInt();
			if(exe.modBook(bookTitle, price)) {
				System.out.println("수정완료");
			}else {
				System.out.println("수정실패");
			}
			
			break;
			
		case 5://삭제
			System.out.print("삭제할 책제목 > ");
			bookTitle = sc.next();
			if(exe.delBook(bookTitle)) {
				System.out.println("삭제완료");
			}else {
				System.out.println("삭제실패");
			}
			
			
			break;
			
		case 6://종료
			run = false;
			System.out.println("종료");
			break;

		}
		}
	}
	
}
