package chap4;

import java.util.Scanner;

public class Game369 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		// 1~50 : 369����
		
		// 3,6,9 ���� üũ ����
		// ���� 1~50 �ݺ�
			//1�� �ڸ��� 3,6,9 ���� üũ
		
			//10�� �ڸ��� 3,6,9 ���� üũ

		// ������ 0 -> ����
		// ������ 1 -> ��
		// ������ 2 -> ����
		int[] a = new int[3];
		a[0]=3;
		a[1]=6;
		a[2]=9;
		
		for(int i=1;i<=50;i++) {
			int n1 = i%10; //������
			int n2 = i/10; //��
			
			if(n1 == 3 && n2 == 3 || n1 == 6 && n2 == 3 || n1 == 9 && n2 == 3) {
				System.out.print("����");
			}else if(n1 == 3 || n1 == 6 || n1 == 9) {
				System.out.print("��");
			}else if(n2 == 3 || n2 == 6 || n2 == 9) {
				System.out.print("��");
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
				System.out.print("��\t");
				break;
			case 2:
				System.out.print("����\t");
				break;
		}
			if(i%10 ==0)System.out.println();
		}
		
//		for(int i=1;i<=5;i++) {
//			int n3 = i%10; //������
//			boolean w = true;
//			if(n3 ==3 || n3 ==6 || n3 ==9) {
//				sb.append("��");
//				w = false;
//			}
//			for(int j=1;j<=10;j++) {
//				int n4 = j%10; //������
//				if(n4 ==3 || n4 ==6 || n4 ==9) {
//					sb.append("��");
//					sb.append("\t");
//				}else if(!w){
//					sb.append(i+"j");
//					sb.append("\t");
//				}
//			}
//			sb.append("\n");
//		}
//		System.out.println(sb);
		
		//������ȯ
		Scanner sc = new Scanner(System.in);
		int result = 0;
		int[] coin = new int[4];
		
		System.out.print("##��ȯ�� �ݾ� : ");
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
		System.out.println("500�� ¥�� : " + coin[0] + "��");
		System.out.println("100�� ¥�� : " + coin[1] + "��");
		System.out.println("50��  ¥�� : " + coin[2] + "��");
		System.out.println("10��  ¥�� : " + coin[3] + "��");
		System.out.println("��ȯ   �ݾ� : " + result + "��");
		System.out.println("����   �ݾ� : " + total + "��");
		
//		System.out.print("##��ȯ�� �ݾ� : ");
//		int money = sc.nextInt();
//		System.out.println("500�� ¥�� : " + money/500 + "��");
//		int remoney = money % 500;
//		System.out.println("100�� ¥�� : " + remoney/100 + "��");
//		remoney %= 100;
//		System.out.println("50�� ¥�� : " + remoney/50 + "��");
//		remoney %= 50;
//		System.out.println("10�� ¥�� : " + remoney/10 + "��");
//		remoney %= 10;
//		System.out.println("��ȯ   �ݾ� : " + (money - remoney));
//		System.out.println("����   �ݾ� : " + remoney);
		
		
		//���� ���� ����
		int N = (int)(Math.random() * 100)+1;
		
		while(true) {
			System.out.print("���� �Է� : ");
			int N1 = sc.nextInt();
			if(N == N1) {
				System.out.println("�����մϴ�.");
				break;
			}else if(N1 > N){
				System.out.println("down�ϼ���!");
			}else if(N1 < N){
				System.out.println("up�ϼ���!");
			}
		} //�߰� �Ǿ����ϴ�.
		
	}

}
