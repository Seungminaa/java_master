package chap1;

import java.util.*;

public class Exam98 {

	public static void main(String[] args) {
		//1��
		String name = "���ڹ�";
		int age = 25;
		String tel1="010" , tel2="123", tel3="4567";
		System.out.println("�̸�: " + name);
		System.out.print("����: " + age + "\n");
		System.out.printf("��ȭ: %s-%s-%s",tel1,tel2,tel3);
		
		//2��
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ù��° ��:");
		String strNum1 = sc.nextLine();
		
		System.out.print("�ι�° ��:");
		String strNum2 = sc.nextLine();
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 + num2;
		System.out.println("���� ���:" + result);
		
		
		//3��
		System.out.print("�̸� : ");
		String name1 = sc.nextLine();
		System.out.print("�ֹι�ȣ : ");
		String num = sc.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phoneNum = sc.nextLine();
		String phoneNum1 = phoneNum.substring(0,3);
		String phoneNum2 = phoneNum.substring(3,6);
		String phoneNum3 = phoneNum.substring(6,9);
		
		
		
		System.out.println("[�ʼ� ���� �Է�]");
		System.out.println("1. �̸�:" + name1);
		System.out.println("2. �ֹι�ȣ �� 6�ڸ�:" + num);
		System.out.println("3. ��ȭ��ȣ:" + phoneNum1+ "-" + phoneNum2 +"-"+ phoneNum3);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // end main

} // end class
