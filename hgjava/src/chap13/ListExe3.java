package chap13;

import java.util.*;

public class ListExe3 {

	public static void main(String[] args) {

		// 회원등록(회원번호, 이름, 포인트)
		// 1.등록 2.이름조회 3.포인트변경 4.삭제 5.종료
		List<Mem> mems = new ArrayList<Mem>();
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		Mem member = null;
		while (run) {
			System.out.println("1.등록 2.이름조회 3.포인트변경 4.삭제 5.종료");
			System.out.print("입력 > ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				System.out.print("회원번호 > ");
				int num1 = sc.nextInt();
				System.out.print("이름 > ");
				String name1 = sc.next();
				System.out.print("포인트 > ");
				int point1 = sc.nextInt();
				member = new Mem(num1, name1, point1);

				mems.add(member);
				break;
			case 2:
				System.out.print("조회할 이름 > ");
				name1 = sc.next();
				for (int i = 0; i < mems.size(); i++) {
					if (mems.get(i).getName().contains(name1)) {
						System.out.println("회원번호 > " + mems.get(i).getNum());
						System.out.println("회원이름 > " + mems.get(i).getName());
						System.out.println("회원포인트 > " + mems.get(i).getPoint());
					}
				}
				break;
			case 3:
				System.out.print("포인트 변경할 이름 > ");
				name1 = sc.next();
				for (int i = 0; i < mems.size(); i++) {
					if (mems.get(i).getName().equals(name1)) {
						System.out.print("변경될 포인트 > ");
						mems.get(i).setPoint(sc.nextInt());
					}
				}

				break;
			case 4:
				System.out.print("삭제할 이름 > ");
				name1 = sc.next();
				for (int i = 0; i < mems.size(); i++) {
					if (mems.get(i).getName().equals(name1)) {
						mems.remove(i);
					}
				}
				System.out.println("삭제 완료");
				break;
			case 5:
				run = false;
				System.out.println("종료");
				break;

			}
		}

	}

}

class Mem {
	int num;
	String name;
	int point;

	Mem(int num, String name, int point) {
		this.num = num;
		this.name = name;
		this.point = point;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}
