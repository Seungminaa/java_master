package chap6;

import java.util.*;

public class BoardApp {
	static BoardExe exe = new BoardExe();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		UserExe uexe = new UserExe();
		String id,pw = null;
		
		while(true) {
			System.out.println("id를 입력 > ");
			id = sc.nextLine();
			System.out.println("pw를 입력 > ");
			pw = sc.nextLine();
			User user = uexe.login(id, pw);
			
			if(user != null) {
				System.out.println(user.getUserName() + "님 환영합니다");
				break;
			}else {
				System.out.println("아디, 비번 확인");
			}
		}
		//초기값 생성
		exe.initData();
		
		while(run) {
			System.out.println("1.등록 || 2.목록 || 3.상세조회 || 4.수정 || 5.삭제 || 6.종료");
			System.out.print("입력 > ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				System.out.print("번호 > ");
				int bnum = Integer.parseInt(sc.nextLine());
				System.out.print("제목 > ");
				String title = sc.nextLine();
				System.out.print("작성자 > ");
				String name = sc.nextLine();
				System.out.print("내용 > ");
				String content = sc.nextLine();
				System.out.print("작성일시 > ");
				String btime = sc.nextLine();
				
				Board board2 = new Board(exe.getSequence(), title, id, content, btime);
				
				if(exe.addBoard(board2)) {
					System.out.println("등록완료");
				}else {
					System.out.println("등록실패");
				}
				break;
				
			case 2: //목록 -> 페이지보기
				Board[] boardAry = exe.boardList();
				showList(boardAry,1);
				while(true) {
					int page = Integer.parseInt(sc.nextLine());
					if(page == 0) {
						break;
					}
					showList(boardAry,page);
				}
				break;
				
			case 3:
				System.out.print("검색할 번호 > ");
				bnum = Integer.parseInt(sc.nextLine());
				Board result = exe.getBoard(bnum);
				if(result !=null) {
					result.showDetail();
				}else {
					System.out.println("검색할 번호가 없습니다");
				}
				break;
				
			case 4:
				System.out.print("수정할 번호 > ");
				bnum = Integer.parseInt(sc.nextLine());
				System.out.print("수정할 글 > ");
				content = sc.nextLine();
				
				if(!exe.checkResponsibility(id, bnum)) {
					System.out.println("권한이 없습니다.");
					continue;
				}
				
				if(exe.modBoard(bnum, content)) {
					System.out.println("수정완료");
				}else {
					System.out.println("수정실패");
				}
				
				break;
				
			case 5:
				System.out.print("삭제할 번호 > ");
				bnum = Integer.parseInt(sc.nextLine());
				
				if(!exe.checkResponsibility(id, bnum)) {
					System.out.println("권한이 없습니다.");
					continue;
				}
				
				if(exe.remBoard(bnum)) {
					System.out.println("삭제완료");
				}else {
					System.out.println("삭제실패");
				}
				break;
				
			case 6:
				System.out.println("종료");
				run = false;
				break;
			
			}
		}
	}
	public static void showList(Board[] boardAry, int page) {
		//페이징 처리
		Board[] pageAry = exe.pageList(boardAry, page);
		for(Board b : pageAry) {
			if(b != null)
				b.showInfo();
		}
		//전체페이지 계산하고 출력
		int cnt = exe.getBoardCount();
		int totalPage = (int)Math.ceil(cnt/5.0);
		
		for(int i=1;i<=totalPage;i++) {
			System.out.print(i + " ");
		}
		System.out.print("\n페이지를 선택하세요(종료하려면 0을 입력) > )");
	}

}
