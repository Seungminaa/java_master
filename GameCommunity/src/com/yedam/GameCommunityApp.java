package com.yedam;

import java.util.*;

public class GameCommunityApp {
	static MemberDAO mdao = new MemberDAO();
	static BoardDAO bdao = new BoardDAO();
	static ProductDAO pdao = new ProductDAO();
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
				int logmenu;
				try {
				logmenu = Integer.parseInt(sc.nextLine());
				}catch (Exception e) {
					continue;
				}
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
					System.out.println("1.게시판 2.물품관리 3.포인트 4.로그아웃");
					System.out.print("입력 > ");
					int adMenu;
					try {
						adMenu = Integer.parseInt(sc.nextLine());
						}catch (Exception e) {
							continue;
						}
					switch (adMenu) {
					case 1: // 게시판
						boolean bRun = true;
						while (bRun) {
							System.out.println("1.목록 및 게시글보기 2.글등록 3.게시판 나가기");
							System.out.print("입력 > ");
							int boardMenu;
							try {
								boardMenu = Integer.parseInt(sc.nextLine());
								}catch (Exception e) {
									continue;
								}
							switch (boardMenu) {
							case 1: // 글 목록
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
									if (bdao.bDetailView(boardDetail) != null) {
										(bdao.bDetailView(boardDetail)).showDetail();
									} else {
										System.out.println("해당 번호가 없습니다.");
										break;
									}
									System.out.println("1.글 삭제 | 2. 게시판으로 가기");
									System.out.print("입력 > ");
									int boardUD = Integer.parseInt(sc.nextLine());
									switch (boardUD) {
									case 1: // 글 삭제
										if (bdao.boardDelAdmin(boardDetail)) {
											System.out.println("글이 삭제되었습니다.");
										} else {
											System.out.println("글 삭제에 실패하였습니다.");
										}
										break;

									case 2:
										continue;
									}
									break;
								}
								break;

							case 2: // 글 등록
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
						} // 게시판 while
						continue;

					case 2:
						boolean pRun = true;
						while (pRun) { // 물품
							System.out.println("1.물품목록보기 2.물품등록 3.물품수정 4.물품삭제 5.뒤로가기");
							System.out.print("입력 > ");
							int prodMenu;
							try {
								prodMenu = Integer.parseInt(sc.nextLine());
								}catch (Exception e) {
									continue;
								}
							switch (prodMenu) {
							case 1: // 물품목록
								System.out.println("==============물품목록===============");
								System.out.println("물품코드\t물품명\t물품가격\t물품수량");
								for (ProductAdmin b : pdao.prodList()) {
									b.showprod();
								}
								System.out.println("================================");
								break;
							case 2:
								System.out.print("등록할 물품명 > ");
								String pName = sc.nextLine();
								System.out.print("가격 > ");
								int pPrice = Integer.parseInt(sc.nextLine());
								System.out.print("물품수량 > ");
								int pCount = Integer.parseInt(sc.nextLine());
								if (pdao.prodAdd(pName, pPrice, pCount)) {
									System.out.println("물품등록에 성공했습니다.");
								} else {
									System.out.println("동일 seq로 인해 물품등록에 실패했습니다.");
								}
								break;

							case 3:
								System.out.print("수정할 물품코드 > ");
								int seq = Integer.parseInt(sc.nextLine());
								System.out.print("수정될 물품명 > ");
								pName = sc.nextLine();
								System.out.print("수정될 가격 > ");
								pPrice = Integer.parseInt(sc.nextLine());
								System.out.print("수정될 물품수량 > ");
								pCount = Integer.parseInt(sc.nextLine());
								if (pdao.prodMod(seq, pName, pPrice, pCount)) {
									System.out.println(seq + " 물품을 수정했습니다.");
								} else {
									System.out.println("맞지 않는 물품코드 입니다.");
								}
								break;

							case 4:
								System.out.print("삭제할 물품코드 > ");
								seq = Integer.parseInt(sc.nextLine());
								if (pdao.prodDel(seq)) {
									System.out.println("물품삭제에 성공했습니다.");
								} else {
									System.out.println("물품등록 실패");
								}
								break;

							case 5:
								pRun = false;
								break;
							}
						} // 물품 while
						continue;
					case 3:
						boolean pointRun = true;
						while (pointRun) { // 포인트
							System.out.println("1.포인트 주기 2.포인트 보유현황 3.뒤로가기");
							System.out.print("입력 > ");
							int pointMenu;
							try {
								pointMenu = Integer.parseInt(sc.nextLine());
								}catch (Exception e) {
									continue;
								}
							switch (pointMenu) {
							case 1: // 포인트 주기
								System.out.print("포인트 줄 아이디 > ");
								String ids = sc.nextLine();
								System.out.print("포인트양 > ");
								int pNum = Integer.parseInt(sc.nextLine());
								if (mdao.pointAddAdmin(ids, pNum)) {
									System.out.println(ids + "에게 " + pNum + "만큼 포인트를 주었습니다");
								} else {
									System.out.println("포인트가 부족하거나 양도해줄 아이디가 맞지 않습니다.");
								}
								break;

							case 2: // 포인트 보유현황
								System.out.println("아이디\t 포인트");
								System.out.println("========================");
								for (Member m : mdao.pointList()) {
									m.showPoint();
								}
								System.out.println("========================");
								break;
							case 3:
								pointRun = false;
								break;
							default:
								System.out.println("존재하지 않는 선택지입니다.");
								break;
							}
						}
						continue;
					case 4:
						run = false;
						continue;

					}
				}
			} else { // 일반 사용자 목록
				while (run) {
					System.out.println("1.게임 2.게시판 3.포인트 4.물품구매 5.구매목록 6.로그아웃");
					System.out.print("입력 > ");
					int cosMenu;
					try {
						cosMenu = Integer.parseInt(sc.nextLine());
						}catch (Exception e) {
							continue;
						}
					switch (cosMenu) {
					case 1: // 게임
						boolean gRun = true;
						while (gRun) {
							System.out.println("1.도둑잡기게임 2.숫자맞추기게임 3.가위바위보게임 4.나가기");
							System.out.print("입력 > ");
							int gameMenu = Integer.parseInt(sc.nextLine());
							// 게임에서 승리시 point 오르게끔(id기준)
							switch (gameMenu) {
							case 1: // 도둑잡기 게임

								// 카드설정
								int[] deck = new int[27];
								for (int i = 0; i < 13; i++) {
									deck[i] = i + 1;
								}
								for (int i = 13; i < 26; i++) {
									deck[i] = i - 12;
								}
								deck[26] = 99; // 조커
								for (int i = 0; i < deck.length; i++) {
									int j = (int) (Math.random() * 27);
									int temp = deck[i];
									deck[i] = deck[j];
									deck[j] = temp;
								}
								List<Integer> userCard = new LinkedList<>();
								List<Integer> dealerCard = new LinkedList<>();

								System.out.println("도둑잡기 게임은 포인트 배팅시스템입니다. \n승리시 배팅금액의 2배를 가져가게 됩니다.");
								System.out.println("단, 배팅금액이 너무 적을시 포인트가 증가되지 않을수 있습니다.");
								System.out.println("도둑은 99번입니다.");
								System.out.println("--------------------------------");
								System.out.print("배팅할 포인트 > ");
								int money = Integer.parseInt(sc.nextLine());
								if(money > pdao.pricePoint(id)) {
									System.out.println("보유 포인트가 부족합니다.");
									break;
								}
								System.out.println("--------------------------------");
								for (int i = 0; i < 13; i++) {
									userCard.add(deck[i]);
									dealerCard.add(deck[i + 13]);
								}
								userCard.add(deck[26]);
								// 카드주고 받기
								while (true) {

									Set<Integer> set = new HashSet<Integer>(userCard);
									Set<Integer> set2 = new HashSet<Integer>(dealerCard);
									int[] strs = new int[userCard.size()]; // 자신카드 중복체크
									int count = 0;

									for (int str : set) { //
										if (Collections.frequency(userCard, str) > 1) {
											strs[count] = str;
											count++;
										}
									}

									for (int j = 0; j < count; j++) {
										for (int i = 0; i < userCard.size(); i++) {
											if (userCard.get(i) == strs[j]) {
												userCard.remove(i);
												i--;
											}
										}
									}

									int[] str2 = new int[dealerCard.size()]; // 상대카드 중복체크
									count = 0;
									for (int str : set2) {
										if (Collections.frequency(dealerCard, str) > 1) {
											str2[count] = str;
											count++;
										}
									}

									for (int j = 0; j < count; j++) {
										for (int i = 0; i < dealerCard.size(); i++) {
											if (dealerCard.get(i) == str2[j]) {
												dealerCard.remove(i);
												i--;
											}
										}
									}
									if (dealerCard.size() == 0) {
										System.out.println("패배하셨습니다.");
										mdao.getPoint1_1(id, money);
										break;
									}
									
									if (userCard.size() == 0) {
										System.out.println("승리하셨습니다.");
										mdao.getPoint1(id, money);
										break;
									}
									System.out.println("현재 보유 카드 : " + userCard);
									System.out.println("딜러의 보유카드수 : " + dealerCard.size());
									System.out.print("딜러의 카드수 중에서 받을 카드를 선택하세요.");
									System.out.print("입력 > ");
									int rec;
									while(true) {
										rec = Integer.parseInt(sc.nextLine()) - 1;
										if(rec<dealerCard.size()) {
											break;
										}else {
											System.out.println("숫자가 맞지 않습니다. 다시 입력해주세요.");
											System.out.print("입력 > ");
										}
									}

									userCard.add(dealerCard.get(rec));
									dealerCard.remove(rec);
									
									strs = new int[userCard.size()]; // 자신카드 중복체크
									count = 0;

									for (int str : set) { //
										if (Collections.frequency(userCard, str) > 1) {
											strs[count] = str;
											count++;
										}
									}

									for (int j = 0; j < count; j++) {
										for (int i = 0; i < userCard.size(); i++) {
											if (userCard.get(i) == strs[j]) {
												userCard.remove(i);
												i--;
											}
										}
									}
									
									if (userCard.size() == 0) {
										System.out.println("승리하셨습니다.");
										mdao.getPoint1(id, money);
										break;
									}

									if (dealerCard.size() == 0) {
										System.out.println("패배하셨습니다.");
										mdao.getPoint1_1(id, money);
										break;
									}
									rec = (int) (Math.random() * userCard.size());
									dealerCard.add(userCard.get(rec));
									userCard.remove(rec);
									
								}

								break;
							case 2: // 숫자 추측 게임
								System.out.println("주어진 숫자는 1~1000 단위 숫자입니다.");
								System.out.println("15초 내로 클리어시 100포인트가 주어집니다.");
								int N = (int) (Math.random() * 1000) + 1;
								long start = System.currentTimeMillis();
								int gamePoint = 100;
								while (true) {
									System.out.print("숫자 입력 : ");
									int N1;
									try {
										N1 = Integer.parseInt(sc.nextLine());
									} catch (Exception e) {
										continue;
									}
									if (N == N1) {
										long end = System.currentTimeMillis();
										long totalTime = (end - start) / 1000;
										System.out.println("클리어");
										mdao.getPoint2(id, gamePoint, totalTime);
										System.out.println("걸린시간:" + totalTime + "초");
										break;
									} else if (N1 > N) {
										System.out.println("down하세요!");
									} else if (N1 < N) {
										System.out.println("up하세요!");
									}
								}
								break;
							case 3: // 가위바위보 게임
								System.out.println("20초내에 3연승시 100포인트가 주어집니다.");
								start = System.currentTimeMillis();
								gamePoint = 100;
								int count = 0;
								while (count < 3) {
									int com = (int) (Math.random() * 3) + 1;
									System.out.println("가위바위보중 1개를 선택해 주세요.");
									System.out.println("1.가위 2.바위 3.보");
									int user;
									try {
										user = Integer.parseInt(sc.nextLine());
									} catch (Exception e) {
										continue;
									}
									switch (user) {
									case 1: // 가위
										switch (com) {
										case 1:
											System.out.println("비겼습니다.");
											count = 0;
											break;
										case 2:
											System.out.println("졌습니다.");
											count = 0;
											break;
										case 3:
											System.out.println("이겼습니다.");
											count++;
											break;
										}
										break;
									case 2: // 바위
										switch (com) {
										case 1:
											System.out.println("이겼습니다.");
											count++;
											break;
										case 2:
											System.out.println("비겼습니다.");
											count = 0;
											break;
										case 3:
											System.out.println("졌습니다.");
											count = 0;
											break;
										}
										break;
									case 3: // 보
										switch (com) {
										case 1:
											System.out.println("졌습니다.");
											count = 0;
											break;
										case 2:
											System.out.println("이겼습니다.");
											count++;
											break;
										case 3:
											System.out.println("비겼습니다.");
											count = 0;
											break;
										}
										break;

									default:
										System.out.println("번호를 잘못입력하였습니다.");
										System.out.println("횟수를 초기화했습니다.");
										count = 0;
										break;
									}
								}
								long end = System.currentTimeMillis();
								long totalTime = (end - start) / 1000;
								System.out.println("클리어");
								mdao.getPoint3(id, gamePoint, totalTime);
								System.out.println("걸린시간:" + totalTime + "초");

								break;

							case 4:
								gRun = false;
								break;
							}
						}

						continue;

					case 2:

						boolean bRun = true;
						while (bRun) {
							System.out.println("1.목록 및 게시글보기 2.글등록 3.게시판 나가기");
							System.out.print("입력 > ");
							int boardMenu= Integer.parseInt(sc.nextLine());
							switch (boardMenu) {
							case 1: // 글 목록
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
									if (bdao.bDetailView(boardDetail) != null) {
										(bdao.bDetailView(boardDetail)).showDetail();
									} else {
										System.out.println("해당 번호가 없습니다.");
										break;
									}
									System.out.println("1.글 수정 | 2.글 삭제 | 3. 게시판으로 가기");
									System.out.print("입력 > ");
									int boardUD = Integer.parseInt(sc.nextLine());
									switch (boardUD) {
									case 1: // 글 수정
										System.out.print("수정할 글제목 > ");
										String bTitle = sc.nextLine();
										System.out.print("수정할 글내용(최대 500자까지 가능) > ");
										String bContent = sc.nextLine();
										if (bdao.boardMod(id, boardDetail, bTitle, bContent)) {
											System.out.println("글이 수정되었습니다.");
										} else {
											System.out.println("글 수정 권한이 없습니다.");
										}
										break;

									case 2:
										if (bdao.boardDel(id, boardDetail)) {
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

							case 2: // 글 등록
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
						} // 게시판 while
						continue;
					case 3:
						System.out.println("1.잔여포인트 확인 2.포인트 양도");
						System.out.print("입력 > ");
						int pointMenu = Integer.parseInt(sc.nextLine());
						switch (pointMenu) {
						case 1: // 잔여포인트 확인
							mdao.pointCheck(id);
							break;

						case 2: // 포인트 양도
							System.out.print("포인트 양도해줄 아이디 > ");
							String ids = sc.nextLine();
							System.out.print("양도해줄 포인트양 > ");
							int assignNum = Integer.parseInt(sc.nextLine());
							if (mdao.pointAssign(id, ids, assignNum)) {
								System.out.println(id + "에서 " + ids + "로 " + assignNum + "만큼 포인트를 양도했습니다");
							} else {
								System.out.println("포인트가 부족하거나 양도해줄 아이디가 맞지 않습니다.");
							}
							break;

						default:
							System.out.println("존재하지 않는 선택지입니다.");
							break;
						}
						break;

					case 4:
						System.out.println("===============================");
						System.out.println("상품코드 \t상품명 \t가격 \t상품재고량");
						for (ProductAdmin b : pdao.prodList()) {
							b.showprod();
						}
						System.out.println("===============================");
						System.out.print("구매할 상품번호를 입력해주세요(뒤로가려면 0을 눌러주세요) > ");
						int buyNum = Integer.parseInt(sc.nextLine());
						switch (buyNum) {
						case 0:
							break;

						default:
							System.out.print("수량을 입력하세요 > ");
							int prodOQ = Integer.parseInt(sc.nextLine());
							if (pdao.prodBuy(prodOQ, id, buyNum)) {
								System.out.print("주소를 입력하세요 > ");
								String prodAddr = sc.nextLine();
								pdao.prodBuyComplet(prodOQ, id, buyNum, prodAddr);
							} else {
								System.out.println("구매에 실패하였습니다.");
							}
							break;
						}
						break;

					case 5:
						pdao.prodBuyList(id);

						break;

					case 6:
						run = false;
						continue;
					}
				}

			}

		} // 큰 while
	}
}
