package chap6;

import java.util.*;

public class BoardApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board[] board = new Board[100];
		boolean run = true;
		
		while(run) {
			System.out.println("1.등록 || 2.목록 || 3.상세조회 || 4.종료");
			System.out.print("입력 > ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				for(int i=0;i<board.length;i++) {
					if(board[i] == null) {
						System.out.print("번호");
						int bnum = Integer.parseInt(sc.nextLine());
						System.out.print("제목");
						String title = sc.nextLine();
						System.out.print("작성자");
						String name = sc.nextLine();
						System.out.print("내용");
						String content = sc.nextLine();
						System.out.print("작성일시");
						String btime = sc.nextLine();
				
						Board board2 = new Board(bnum, title, name, content, btime);
						
						board[i] = board2;
						break;
					}
				}
				
				break;
				
			case 2:
				
				break;
				
			case 3:
				
				break;
				
			case 4:
				
				break;
			
			}
		}
	}

}
