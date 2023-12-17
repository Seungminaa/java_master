package miniPrj;

import java.util.*;

public class GameCommunityApp {
	static MemberDao mdao = new MemberDao();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			boolean logrun = true;
			boolean adminVu = false;
			boolean run = true;

			while (logrun) {
				System.out.println("1.로그인 2.계정생성 3.계정삭제");
				System.out.print("입력 > ");
				int logmenu = Integer.parseInt(sc.nextLine());
				switch (logmenu) {
				case 1:
					System.out.println("id를 입력 > ");
					String id = sc.nextLine();
					System.out.println("pw를 입력 > ");
					String pw = sc.nextLine();
					if (mdao.login(id, pw)) {
						System.out.println(id + " 계정으로 접속하였습니다.");
						if (id.contains("admin")) {
							adminVu = true;
						}
						logrun = false;
						break;
					} else {
						System.out.println("접속에 실패하였습니다.");
					}
					break;
				case 2:
					System.out.println("생성할 id를 입력 > ");
					id = sc.nextLine();
					System.out.println("pw를 입력 > ");
					pw = sc.nextLine();
					if (mdao.addLogin(id, pw)) {
						System.out.println("생성완료");
					} else {
						System.out.println("생성실패");
					}
					break;
				case 3:
					System.out.println("삭제할 id를 입력 > ");
					id = sc.nextLine();
					System.out.println("pw를 입력 > ");
					pw = sc.nextLine();
					if (mdao.delLogin(id, pw)) {
						System.out.println("삭제완료");
					} else {
						System.out.println("삭제실패");
					}
					break;

				}

			}
			if (adminVu) { // 관리자 목록
				while (run) {
					System.out.println("1.게시판 2.물품등록 3.로그아웃");
					System.out.print("입력 > ");
					int menu = Integer.parseInt(sc.nextLine());
					switch (menu) {
					case 1:

						break;

					case 2:

						break;

					case 3:
						run = false;
						continue;

					}
				}
			} else { // 사용자 목록
				while (run) {
					System.out.println("1.게임 2.게시판 3.포인트 4.물품구매 5.로그아웃");
					System.out.print("입력 > ");
					int menu = Integer.parseInt(sc.nextLine());
					switch (menu) {
					case 1:
						
						break;

					case 2:
						
						break;

					case 3:

						break;

					case 4:

						break;

					case 5:
						run = false;
						continue;

					}
				}

			}
		}
	}
}
