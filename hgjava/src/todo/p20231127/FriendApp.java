package todo.p20231127;

import java.util.*;

public class FriendApp {
	static Scanner sc = new Scanner(System.in);
	static Friend[] friends = null;
	static int friendNum = 0;
	
	public static void info() { 			// 입력
		System.out.println("친구정보 입력 > ");
		for(int i=0;i<friends.length;i++) {
			Friend friend = new Friend();
			System.out.print("이름 > ");
			friend.name = sc.next();
			System.out.print("연락처 > ");
			friend.phoneNum = sc.nextInt();
			System.out.print("혈액형 > ");
			friend.bloodType = sc.next();
			
			friends[i] = friend;
		}
	}
	public static void searchInfo() { 		// 목록
		System.out.println("목록 > ");
		for(Friend n : friends) {
			System.out.println("이름 : " + n.name);
			System.out.println("연락처 : " + n.phoneNum);
			System.out.println("혈액형 : " + n.bloodType);
		}
	}
	public static void modifyInfo() { 		// 수정
		boolean find = true;
		System.out.print("수정할 이름 > ");
		String name = sc.next();
		
		for(int i=0;i<friends.length;i++) {
			if(name.equals(friends[i].name)) {
				System.out.print("수정될 연락처 : ");
				friends[i].phoneNum = sc.nextInt();
				System.out.print("\n 수정될 혈액형 : ");
				friends[i].bloodType = sc.next();
				find = false;
			}
		}
		if(find) {
			System.out.println("이름이 존재하지 않습니다.");
		}
	}
	
	public static void main(String[] args) {
		
		boolean run = true;
		
		
		while(run) {
			System.out.println("1.친구수 || 2.입력 || 3.목록 || 4.수정 || 5.종료");
			System.out.print("입력 : ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1: {
				System.out.print("친구수 입력 > ");
				friendNum = sc.nextInt();
				friends = new Friend[friendNum];
				System.out.println();
				break;
			}
			case 2 : {
				info();
				break;
			}
			case 3 : {
				searchInfo();
				break;
			}
			case 4 : {
				modifyInfo();
				break;
			}
			case 5 : {
				System.out.println("종료");
				run = false;
				break;
			}
			
			}
		} 
		
	} //main

}
