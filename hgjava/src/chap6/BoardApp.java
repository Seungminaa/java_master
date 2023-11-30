package chap6;

import java.util.*;

//M(odel) V(eiw) C(ontrol)
public class BoardApp {
	// static BoardExe exe = new BoardExe();
	// 데이터마다 다른 정보를 담을 필요가 없는 클래스는 static 멤버선언
	private Scanner sc = new Scanner(System.in);
	private String id, pw = null;
	//싱글톤 방식의 인스턴스 생성
	static BoardApp instance = new BoardApp();
	//생성자
	private BoardApp() {
		
	}
	
	public static BoardApp getInstance() {
		return instance;
	}
	
	public void start() {
		boolean run = true;

		UserExe uexe = new UserExe();

		while (true) {
			System.out.println("id를 입력 > ");
			id = sc.nextLine();
			System.out.println("pw를 입력 > ");
			pw = sc.nextLine();
			User user = uexe.login(id, pw);

			if (user != null) {
				System.out.println(user.getUserName() + "님 환영합니다");
				break;
			} else {
				System.out.println("아디, 비번 확인");
			}
		}
		// 초기값 생성
		BoardExe.initData();

		while (run) {
			System.out.println("1.등록 || 2.목록 || 3.상세조회 || 4.수정 || 5.삭제 || 6.종료");
			System.out.print("입력 > ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1: //글등록
				boardAdd();
				break;

			case 2: // 목록 -> 페이지보기
				boardList();
				break;

			case 3:
				getBoard();
				break;

			case 4:
				boardEdit();
				break;

			case 5:
				boardDel();
				
				break;

			case 6:
				System.out.println("종료");
				run = false;
				break;

			}
		}
	}
	private void boardAdd() {
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

		Board board2 = new Board(BoardExe.getSequence(), title, id, content, btime);

		if (BoardExe.addBoard(board2)) {
			System.out.println("등록완료");
		} else {
			System.out.println("등록실패");
		}
	}
	private void boardList() {
		Board[] boardAry = BoardExe.boardList();
		showList(boardAry, 1);
		while (true) {
			int page = Integer.parseInt(sc.nextLine());
			if (page == 0) {
				break;
			}
			showList(boardAry, page);
		}
	}
	private void getBoard() {
		System.out.print("검색할 번호 > ");
		int bnum = Integer.parseInt(sc.nextLine());
		Board result = BoardExe.getBoard(bnum);
		if (result != null) {
			result.showDetail();
		} else {
			System.out.println("검색할 번호가 없습니다");
		}
	}
	private void boardEdit() {
		System.out.print("수정할 번호 > ");
		int bnum = Integer.parseInt(sc.nextLine());
		System.out.print("수정할 글 > ");
		String content = sc.nextLine();

		if (!BoardExe.checkResponsibility(id, bnum)) {
			System.out.println("권한이 없습니다.");
			return;
		}

		if (BoardExe.modBoard(bnum, content)) {
			System.out.println("수정완료");
		} else {
			System.out.println("수정실패");
		}
	}
	private void boardDel() {
		System.out.print("삭제할 번호 > ");
		int bnum = Integer.parseInt(sc.nextLine());

		if (!BoardExe.checkResponsibility(id, bnum)) {
			System.out.println("권한이 없습니다.");
			return;
		}

		if (BoardExe.remBoard(bnum)) {
			System.out.println("삭제완료");
		} else {
			System.out.println("삭제실패");
		}
	}

	private void showList(Board[] boardAry, int page) {
		// 페이징 처리
		Board[] pageAry = BoardExe.pageList(boardAry, page);
		for (Board b : pageAry) {
			if (b != null)
				b.showInfo();
		}
		// 전체페이지 계산하고 출력
		int cnt = BoardExe.getBoardCount();
		int totalPage = (int) Math.ceil(cnt / 5.0);

		for (int i = 1; i <= totalPage; i++) {
			System.out.print(i + " ");
		}
		System.out.print("\n페이지를 선택하세요(종료하려면 0을 입력) > )");
	}

}
