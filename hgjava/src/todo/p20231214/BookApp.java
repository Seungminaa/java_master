package todo.p20231214;

import java.util.*;

public class BookApp {
	static Scanner sc = new Scanner(System.in);
	static BookDAO dao = new BookDAO();
	public static void main(String[] args) {
		boolean run = true;
		
		while(run) {
			System.out.println("1.등록 2.목록 3.단건조회 4.수정 5.삭제 6.종료");
			System.out.print("입력 > ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1://등록
				System.out.print("책번호 > ");
				String bookCode = sc.nextLine();
				System.out.print("책제목 > ");			
				String bookTitle = sc.nextLine();
				System.out.print("저자 > ");			
				String author = sc.nextLine();
				System.out.print("출판사 > ");			
				String press = sc.nextLine();
				System.out.print("가격 > ");			
				int price = Integer.parseInt(sc.nextLine());
				
				Book std = new Book(bookCode,bookTitle,author,press,price);
				if(dao.addBook(std)) {
					System.out.println("등록성공");
				}else {
					System.out.println("등록실패");
				}
				break;
				
			case 2://목록
				for(Book b : dao.listBook()) {
					b.showInfo();
				}
				break;
				
			case 3://단건조회
				System.out.println("찾을 책제목 > ");
				bookTitle = sc.nextLine();
				 (dao.searchBook(bookTitle)).showInfo();
				break;
				
			case 4://수정
				System.out.print("수정할 책제목 > ");
				bookTitle = sc.nextLine();
				System.out.print("수정할 가격 > ");
				price = Integer.parseInt(sc.nextLine());
				if(dao.modBook(bookTitle, price)) {
					System.out.println("수정완료");
				}else {
					System.out.println("수정실패");
				}
				
				break;
				
			case 5://삭제
				System.out.print("삭제할 책제목 > ");
				bookTitle = sc.nextLine();
				if(dao.delBook(bookTitle)) {
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
