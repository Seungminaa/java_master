package chap5;

import java.util.Scanner;

public class StudentApp2 {
	static Scanner sc = new Scanner(System.in);
	static Student[] students = null;
	static int count =0;
	
	public static void addStudent() {
		System.out.println("학생정보 입력 > ");
		for(int i=0; i<students.length;i++) {
			Student student = new Student();
			System.out.print("학생의 이름 입력 > ");
			student.name = sc.next();
			System.out.print("학생의 점수 입력 > ");
			student.score = sc.nextInt();
			System.out.print("성별 입력 > ");
			student.gender = sc.next();
			
			students[i] = student;
		}
	} //end of addStudent()
	
	public static void searchStudent() {
		System.out.print("조회할 이름 입력 > ");
		String name = sc.next();
		
		//학생이름 - 점수 출력
		for(Student i : students) {
			if(name.equals(i.name)) {
			System.out.println("이름 : " + i.name);
			System.out.println("점수 : " + i.score);
			System.out.println("성별 : " + i.gender);
			}else{
			count++;
			}
		}
		if(count == students.length) {
			System.out.println("찾는 이름이 없습니다.");
		}
	} // end of searchStudent()
	
	public static void analysis() {
		int sumOfMen = 0, cntOfMen = 0;
		int sumOfWomen = 0, cntOfWomen = 0;
		for(Student st : students) {
			if(st.gender.equals("남")) {
				sumOfMen += st.score;
				cntOfMen++;
			}else if(st.gender.equals("여")) {
				sumOfWomen += st.score;
				cntOfWomen++;
			}
		}
		System.out.println("남학생의 평균 : " + (sumOfMen * 1.0 / cntOfMen));
		System.out.println("여학생의 평균 : " + (sumOfWomen * 1.0 / cntOfWomen));
	}//end of analysis()
	
	public static void modify() {
		//이름입력 -> 변경점수
		System.out.print("조회할 이름 입력 > ");
		String name = sc.next();
		boolean exists = false;
		
		for(int i=0;i<students.length;i++) {
			//조건추가
			if(name.equals(students[i].name)) {
				System.out.print("변경할 점수입력 > ");
				students[i].score = sc.nextInt();
				exists = true;
			}
		}
		if(!exists) {
			System.out.println("이름이 존재하지 않습니다.");
		}
		
	}//end of modify()
	
	public static void main(String[] args) {
		boolean run = true;
		
		int studentNum = 0;
		
		while(run) {
			System.out.println("1.학생수 || 2.점수입력 || 3.조회 || 4.분석(최고점수, 평균) ||5.수정 || 6.종료");
			System.out.print("입력 : ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				System.out.print("학생수 입력 > ");
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
				System.out.println("종료합니다.");
				run = false;
				break;
			}
		}//while
	}//main
}
