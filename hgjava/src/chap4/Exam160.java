package chap4;

import java.util.Scanner;

public class Exam160 {
	public static void main(String[] args) {
		//문제2 : 3의 배수 합
		int sum = 0;
		
		for(int i=1;i<=100;i++) {
			if(i%3==0) {
				sum += i;
			}
		}
		System.out.println(sum);
		
		//문제3
		
		
		while(true) {
			int a = (int)(Math.random() * 6) +1;
			int b = (int)(Math.random() * 6) +1;
			
			System.out.println("("+a + "," + b + ")");
			if(a+b==5) {
				break;
			}
		}
		System.out.println("종료");
		
		//문제4
		
		for(int i=0;i<=10;i++) {
			for(int j=0;j<=10;j++) {
				if(4*i+5*j==60) {
					System.out.printf("(%d,%d)",i,j);
				}
			}
		}
        System.out.println();
        
        
		//문제5
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		//문제6
		
		
		
		
		
		//문제7
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("---------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("---------------------------");
			System.out.print("선택> ");
			int num = sc.nextInt();
			
			switch (num){
			case 1: {
				System.out.print("예금액> ");
				balance += sc.nextInt();
				break;
			}
			case 2: {
				System.out.print("출금액> ");
				int num2 = sc.nextInt();
				if(balance<num2) {
					System.out.println("잔액이 부족합니다.");
				}else {
					balance -= num2;
				}
				break;
			}
			case 3: {
				System.out.println("잔고> " + balance);
				
				break;
			}
			case 4: {
				run = false;
				System.out.println("프로그램 종료");
				break;
			}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
