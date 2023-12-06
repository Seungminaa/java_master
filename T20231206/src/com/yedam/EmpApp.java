package com.yedam;

import java.util.*;

public class EmpApp {
	static Scanner sc = new Scanner(System.in);
	static EmpDAO empDao = new EmpDAO();

	public static void main(String[] args) {
		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(조건:입사일자) 6.종료");
			System.out.print("입력 > ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				System.out.print("사번 입력 >> ");
				String code = sc.nextLine();
				System.out.print("이름 입력 >> ");
				String name = sc.nextLine();
				System.out.print("전화번호 입력 >> ");
				String phone = sc.nextLine();
				System.out.print("입사일 입력 >> ");
				String day = sc.nextLine();
				System.out.print("급여 입력 >> ");
				int pay = Integer.parseInt(sc.nextLine());

				Employee data = new Employee(code, name, phone, day, pay);
				if (empDao.addList(data)) {
					System.out.println("등록완료");
				} else {
					System.out.println("데이터 타입이 맞지 않아 등록실패");
				}

				break;
			case 2:
				System.out.println("사번 \t이름 \t전화번호");
				for (Employee i : empDao.viewList()) {
					i.empInfo();
				}

				break;
			case 3:
				System.out.print("사번 급여 >> ");
				String total = sc.nextLine();
				try {
					if (empDao.empMod(total)) {
					System.out.println("수정 완료");
				} else {
					System.out.println("수정 실패");
				}
				} catch (Exception e) {
					System.out.println("수정 실패");
				}
				
				break;
			case 4:
				System.out.print("삭제할 사번 >> ");
				code = sc.nextLine();

				if (empDao.empDel(code)) {
					System.out.println("입력한 사번 전부 삭제 완료");
				} else {
					System.out.println("삭제 실패");
				}

				break;
			case 5:
				System.out.print("입사일자 >> ");
				day = sc.nextLine();
				try {
					if (empDao.dateList(day) != null) {
					for (Employee i : empDao.dateList(day)) {
						i.empDateInfo();
					}
				}else {
					System.out.println("해당 입사일 이후 들어온 사람이 없습니다.");
				}
				} catch (Exception e) {
					System.out.println("맞지 않는 데이터 입니다.");
				}
				
				break;
			case 6:
				run = false;
				System.out.println("종료");
				break;

			default:
				System.out.println("주어진 숫자를 입력하세요.");
				break;
			}
		}
	}

}
