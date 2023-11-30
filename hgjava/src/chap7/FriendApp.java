package chap7;

import java.util.*;

public class FriendApp {
	static Scanner sc = new Scanner(System.in);
//	static Friend[] storage = new Friend[10]; 
	static FriendExe fnx = new FriendExe();

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("1.등록 | 2.목록 | 3.상세보기 | 4.종료");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1: // 등록
				addFriend();
				break;
			case 2: // 목록
				friendList();
				break;
			case 3: // 상세보기
				getFriend();
				break;
			default: // 종료
				System.out.println("종료");
				run = false;
				break;

			}
		}
	}

	private static void addFriend() { // 등록
		System.out.println("1.친구 | 2.학교 | 3.회사");
		int subMenu = Integer.parseInt(sc.nextLine());

		Friend friend = null;

		System.out.print("이름 > ");
		String name = sc.nextLine();
		System.out.print("연락처 > ");
		String phone = sc.nextLine();

		if (subMenu == 1) {// 이름,연락처
			friend = new Friend(name, phone); // Friend 인스턴스
		} else if (subMenu == 2) {// 이름,연락처,학교,전공
			System.out.print("학교 > ");
			String univ = sc.nextLine();
			System.out.print("전공 > ");
			String major = sc.nextLine();
			friend = new UnivFriend(name, phone, univ, major);

		} else if (subMenu == 3) {// 이름,연락처,회사,부서
			System.out.print("회사 > ");
			String comp = sc.nextLine();
			System.out.print("부서 > ");
			String dept = sc.nextLine();
			friend = new CompFriend(name, phone, comp, dept);
		}
		// 배열에 추가
//		for(int i=0;i<storage.length;i++) {
//			if(storage[i] == null) {
//				storage[i] = friend;
//				break;
//			}
//		}
		if (fnx.addFriend(friend)) {
			System.out.println("등록완료");
		} else {
			System.out.println("등록실패");
		}
	}

	private static void friendList() { // 목록
//		for(Friend fnd : storage) {
//			if(fnd != null) {
//				System.out.println(fnd.showInfo());
//			}
//		}
		fnx.friendList();
	}

	private static void getFriend() { // 단건목록
		// 이름조회, 연락처조회
		System.out.println("1.이름 2.연락처");
		int subMenu = Integer.parseInt(sc.nextLine());
		String searchCond = "";
		if (subMenu == 1) {
			searchCond = sc.nextLine();
//			for(Friend fnd : storage) {
//				if(fnd != null && fnd.getName().equals(searchCond)) {
//					System.out.println(fnd.showInfo());
//				}
//			}
			Friend[] list = fnx.searchFriend(searchCond);
			for (int i = 0; i < list.length; i++) {
				if (list[i] != null)
					System.out.println(list[i].showInfo());
			}
		} else if (subMenu == 2) {
			searchCond = sc.nextLine();
//			for(Friend fnd : storage) {
//				if(fnd != null && fnd.getPhone().equals(searchCond)) {
//					System.out.println(fnd.showInfo());
//				}
//			}
			System.out.println(fnx.searchPhone(searchCond).showInfo());
		} else {
			System.out.println("1 또는 2중에서 선택해");
		}
	}

	void backup() {
		Friend parent = new Friend();
		parent.setName("홍길동");
		parent.setPhone("010-1111");
		System.out.println(parent.toString());

		UnivFriend child = new UnivFriend();
		child.setName("김철수");
		child.setPhone("010-2222");
		child.setUniv("구미대학교");
		child.setMajor("컴퓨터공학과");
		System.out.println(child.showInfo());

		Friend[] friends = new Friend[10];
		friends[0] = parent;
		friends[1] = child;
	}
}
