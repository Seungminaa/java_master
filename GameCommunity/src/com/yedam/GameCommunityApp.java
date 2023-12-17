package com.yedam;

import java.util.*;

public class GameCommunityApp {
	static MemberDAO mdao = new MemberDAO();
	static BoardDAO bdao = new BoardDAO();
	static Scanner sc = new Scanner(System.in);
	static String id;

	public static void main(String[] args) {
		while (true) {
			boolean logrun = true;
			boolean adminVu = false;
			boolean run = true;

			while (logrun) { // 로그인 while
				System.out.println("1.로그인 2.계정생성 3.계정삭제");
				System.out.print("입력 > ");
				int logmenu = Integer.parseInt(sc.nextLine());
				switch (logmenu) {
				case 1:
					System.out.print("id를 입력 > ");
					id = sc.nextLine();
					System.out.print("pw를 입력 > ");
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
					System.out.print("생성할 id를 입력 > ");
					id = sc.nextLine();
					System.out.print("pw를 입력 > ");
					pw = sc.nextLine();
					if (mdao.addLogin(id, pw)) {
						System.out.println("생성완료");
					} else {
						System.out.println("생성실패");
					}
					break;
				case 3:
					System.out.print("삭제할 id를 입력 > ");
					id = sc.nextLine();
					System.out.print("pw를 입력 > ");
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
					int adMenu = Integer.parseInt(sc.nextLine());
					switch (adMenu) {
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
					int cosMenu = Integer.parseInt(sc.nextLine());
					switch (cosMenu) {
					case 1:

						break;

					case 2:

						boolean bRun = true;
						while (bRun) {
							System.out.println("1.목록 및 게시글보기 2.글등록 3.게시판 나가기");
							System.out.print("입력 > ");
							int boardMenu = Integer.parseInt(sc.nextLine());
							switch (boardMenu) {
							case 1: //글 목록
								System.out.println("==============글목록===============");
								System.out.println("글번호\t글쓴이\t글제목");
								for (Board b : bdao.boardList()) {
									b.showInfo();
								}
								System.out.println("================================");
								System.out.println("0.뒤로 가기 | n.글 상세보기");
								System.out.print("입력 > ");
								int boardDetail = Integer.parseInt(sc.nextLine());
								switch (boardDetail) {
								case 0:
									break;

								default:
									(bdao.bDetailView(boardDetail)).showDetail();
									System.out.println("1.글 수정 | 2.글 삭제 | 3. 게시판으로 가기");
									System.out.print("입력 > ");
									int boardUD = Integer.parseInt(sc.nextLine());
									switch (boardUD) {
									case 1: //글 수정
										System.out.print("수정할 글제목 > ");
										String bTitle = sc.nextLine();
										System.out.print("수정할 글내용(최대 500자까지 가능) > ");
										String bContent = sc.nextLine();
										if (bdao.boardMod(id,boardDetail, bTitle, bContent)) {
											System.out.println("글이 수정되었습니다.");
										} else {
											System.out.println("글 수정 권한이 없습니다.");
										}
										break;
										
									case 2:
										if (bdao.boardDel(id,boardDetail)) {
											System.out.println("글이 삭제되었습니다.");
										} else {
											System.out.println("글 삭제 권한이 없습니다.");
										}
										break;
										
									case 3:
										continue;
									}
									break;
								}

								break;

							case 2: //글 등록
								System.out.print("등록할 글제목 > ");
								String bTitle = sc.nextLine();
								System.out.print("글내용(최대 500자까지 가능) > ");
								String bContent = sc.nextLine();
								if (bdao.boardAdd(id, bTitle, bContent)) {
									System.out.println("글이 등록되었습니다.");
								} else {
									System.out.println("글 등록에 실패하였습니다.");
								}
								break;

							case 3:
								bRun = false;
								break;
							}
						}//게시판 while
						continue;
					case 3:
						System.out.println("1.잔여포인트 확인 2.포인트 양도");
						System.out.print("입력 > ");
						int pointMenu = Integer.parseInt(sc.nextLine());
						switch (pointMenu) {
						case 1: //잔여포인트 확인
							mdao.pointCheck(id);
							break;
						
						case 2: //포인트 양도
							System.out.print("포인트 양도해줄 아이디 > ");
							String ids = sc.nextLine();
							System.out.print("양도해줄 포인트양 > ");
							int assignNum = Integer.parseInt(sc.nextLine());
							if(mdao.pointAssign(id,ids,assignNum)) {
								System.out.println(id +"에서 " + ids + "로 " + assignNum+"만큼 포인트를 양도했습니다");
							}else {
								System.out.println("포인트가 부족하거나 양도해줄 아이디가 맞지 않습니다.");
							}
							break;
							
						default:
							System.out.println("존재하지 않는 선택지입니다.");
							break;
						}

					case 4:

						break;

					case 5:
						run = false;
						continue;

					}
				}

			}

		} // 큰 while
	}
}
