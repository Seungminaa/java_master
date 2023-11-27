package chap5;

import java.util.Scanner;

public class StudentApp2 {
	static Scanner sc = new Scanner(System.in);
	static Student[] students = null;
	static int count =0;
	
	public static void addStudent() {
		System.out.println("�л����� �Է� > ");
		for(int i=0; i<students.length;i++) {
			Student student = new Student();
			System.out.print("�л��� �̸� �Է� > ");
			student.name = sc.next();
			System.out.print("�л��� ���� �Է� > ");
			student.score = sc.nextInt();
			System.out.print("���� �Է� > ");
			student.gender = sc.next();
			
			students[i] = student;
		}
	} //end of addStudent()
	
	public static void searchStudent() {
		System.out.print("��ȸ�� �̸� �Է� > ");
		String name = sc.next();
		
		//�л��̸� - ���� ���
		for(Student i : students) {
			if(name.equals(i.name)) {
			System.out.println("�̸� : " + i.name);
			System.out.println("���� : " + i.score);
			System.out.println("���� : " + i.gender);
			}else{
			count++;
			}
		}
		if(count == students.length) {
			System.out.println("ã�� �̸��� �����ϴ�.");
		}
	} // end of searchStudent()
	
	public static void analysis() {
		int sumOfMen = 0, cntOfMen = 0;
		int sumOfWomen = 0, cntOfWomen = 0;
		for(Student st : students) {
			if(st.gender.equals("��")) {
				sumOfMen += st.score;
				cntOfMen++;
			}else if(st.gender.equals("��")) {
				sumOfWomen += st.score;
				cntOfWomen++;
			}
		}
		System.out.println("���л��� ��� : " + (sumOfMen * 1.0 / cntOfMen));
		System.out.println("���л��� ��� : " + (sumOfWomen * 1.0 / cntOfWomen));
	}//end of analysis()
	
	public static void modify() {
		//�̸��Է� -> ��������
		System.out.print("��ȸ�� �̸� �Է� > ");
		String name = sc.next();
		boolean exists = false;
		
		for(int i=0;i<students.length;i++) {
			//�����߰�
			if(name.equals(students[i].name)) {
				System.out.print("������ �����Է� > ");
				students[i].score = sc.nextInt();
				exists = true;
			}
		}
		if(!exists) {
			System.out.println("�̸��� �������� �ʽ��ϴ�.");
		}
		
	}//end of modify()
	
	public static void main(String[] args) {
		boolean run = true;
		
		int studentNum = 0;
		
		while(run) {
			System.out.println("1.�л��� || 2.�����Է� || 3.��ȸ || 4.�м�(�ְ�����, ���) ||5.���� || 6.����");
			System.out.print("�Է� : ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				System.out.print("�л��� �Է� > ");
				studentNum = Integer.parseInt(sc.next()); // "3" -> 3
				students = new Student[studentNum];
				System.out.println();
				break;
				
			case 2:
				addStudent();
				break;
			
			case 3:
				searchStudent();
				
				break;
			case 4:
				analysis();
	
				break;
			case 5:
				modify();
				break;
			case 6:
				System.out.println("�����մϴ�.");
				run = false;
				break;
			}
		}//while
	}//main
}
