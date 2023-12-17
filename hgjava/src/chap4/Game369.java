package chap4;

import java.util.Scanner;

public class Game369 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		// 1~50 : 369게임
		
		// 3,6,9 갯수 체크 변수
		// 숫자 1~50 반복
			//1의 자리에 3,6,9 갯수 체크
		
			//10의 자리에 3,6,9 갯수 체크

		// 갯수가 0 -> 숫자
		// 갯수가 1 -> ♥
		// 갯수가 2 -> ♥♥
		int[] a = new int[3];
		a[0]=3;
		a[1]=6;
		a[2]=9;
		
		for(int i=1;i<=50;i++) {
			int n1 = i%10; //나머지
			int n2 = i/10; //몫
			
			if(n1 == 3 && n2 == 3 || n1 == 6 && n2 == 3 || n1 == 9 && n2 == 3) {
				System.out.print("♥♥");
			}else if(n1 == 3 || n1 == 6 || n1 == 9) {
				System.out.print("♥");
			}else if(n2 == 3 || n2 == 6 || n2 == 9) {
				System.out.print("♥");
			}else {
				System.out.print(i);
			}
			
			if(n1 == 0) {
				System.out.println();
			}
			System.out.print(" ");
		}
		
		int cnt = 0;
		for (int i = 1; i <= 50; i++) {
			cnt = 0;
			if(i%10==3 || i%10==6 || i%10==9)cnt++;
			if(i/10==3 || i/10==6 || i/10==9)cnt++;
			
			switch (cnt) {
			case 0:
				System.out.print(i + "\t");
				break;
			case 1:
				System.out.print("♥\t");
				break;
			case 2:
				System.out.print("♥♥\t");
				break;
		}
			if(i%10 ==0)System.out.println();
		}
		
//		for(int i=1;i<=5;i++) {
//			int n3 = i%10; //나머지
//			boolean w = true;
//			if(n3 ==3 || n3 ==6 || n3 ==9) {
//				sb.append("♥");
//				w = false;
//			}
//			for(int j=1;j<=10;j++) {
//				int n4 = j%10; //나머지
//				if(n4 ==3 || n4 ==6 || n4 ==9) {
//					sb.append("♥");
//					sb.append("\t");
//				}else if(!w){
//					sb.append(i+"j");
//					sb.append("\t");
//				}
//			}
//			sb.append("\n");
//		}
//		System.out.println(sb);
		
		//동전교환
		Scanner sc = new Scanner(System.in);
		int result = 0;
		int[] coin = new int[4];
		
		System.out.print("##교환할 금액 : ");
		int total = sc.nextInt();
		while(true) {
			if(total > 500) {
				coin[0] = total / 500;
				total -= coin[0] * 500;
				result += 500 * coin[0];
			}else if(total > 100){
				coin[1] = total / 100;
				total -= coin[1] * 100;
				result += 100 * coin[1];
			}else if(total > 50){
				coin[2] = total / 50;
				total -= coin[2] * 50;
				result += 50 * coin[2];
			}else if(total > 10){
				coin[3] = total / 10;
				total -= coin[3] * 10;
				result += 10 * coin[3];
			}else {
				break;
			}
		}
		System.out.println("500원 짜리 : " + coin[0] + "개");
		System.out.println("100원 짜리 : " + coin[1] + "개");
		System.out.println("50원  짜리 : " + coin[2] + "개");
		System.out.println("10원  짜리 : " + coin[3] + "개");
		System.out.println("교환   금액 : " + result + "원");
		System.out.println("남은   금액 : " + total + "원");
		
//		System.out.print("##교환할 금액 : ");
//		int money = sc.nextInt();
//		System.out.println("500원 짜리 : " + money/500 + "개");
//		int remoney = money % 500;
//		System.out.println("100원 짜리 : " + remoney/100 + "개");
//		remoney %= 100;
//		System.out.println("50원 짜리 : " + remoney/50 + "개");
//		remoney %= 50;
//		System.out.println("10원 짜리 : " + remoney/10 + "개");
//		remoney %= 10;
//		System.out.println("교환   금액 : " + (money - remoney));
//		System.out.println("남은   금액 : " + remoney);
		
		
		//숫자 추측 게임
		int N = (int)(Math.random() * 100)+1;
		
		while(true) {
			System.out.print("숫자 입력 : ");
			int N1 = sc.nextInt();
			if(N == N1) {
				System.out.println("축하합니다.");
				break;
			}else if(N1 > N){
				System.out.println("down하세요!");
			}else if(N1 < N){
				System.out.println("up하세요!");
			}
		} //추가 되었습니다.
		
	}

}
