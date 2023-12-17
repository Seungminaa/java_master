package chap3;

import java.util.*;

public class exam128 {

	public static void main(String[] args) {
		//문제4번
		int penNum = 534;
		int stuNum = 30;
		
		int ppsNum = penNum / stuNum;
		int rempNum = penNum % stuNum;
		
		System.out.printf("학생당 연필 수 : %d, 남은 연필 수: %d \n",ppsNum, rempNum);
		
		//문제5-> 강제 타입변환
		
		//문제6
		int value = 365;
		System.out.println(value/100*100);
		
		//문제7 -> 부동소수점 표현 방식 0.1은 0.1보다 큰값
		// 강제타입 변환 (float)0.1
		
		//문제8
		//사다리꼴의 너비 = (윗변 +아랫변) * 높이 / 2
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (lengthTop + lengthBottom) * height / 2.0;
		System.out.println(area);
		
		//문제9
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 수 : ");
		double num1 = sc.nextDouble();
		
		System.out.print("두번째 수 : ");
		double num2 = sc.nextDouble();
		
		
		if(num2 == 0.0) {
			System.out.println("결과:무한대");
		}else {
			System.out.println("결과:" + num1/num2);
		}
		
		//문제10
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
		double var4 = var1 * var1 * Double.parseDouble(var2 + "." + var3);
		System.out.println("원의 넓이:" + var4);
		
		Scanner sc2 = new Scanner(System.in);
		//문제11
		System.out.print("아이디:");
		String name = sc2.nextLine();
		
		System.out.print("패스워드:");
		String strPassword = sc2.nextLine();
		int password = Integer.parseInt(strPassword);
		
		if(name.equals("java")) {
			if(password==12345) {
				System.out.println("로그인 성공");
			}else {
				System.out.println("로그인 실패:패스워드가 틀림");
			}
		}else {
			System.out.println("로그인 실패:아이디가 존재하지 않음");
		}
	}// end main

}// end class
