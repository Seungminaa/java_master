package remind6;

import java.util.*;

public class StudentApp {
	
	public static void main(String[] args) {
		Student[] students = new Student[100];

		Scanner sc = new Scanner(System.in);
		boolean run = true;
		StudentExe exe = new StudentExe();
		StudentDAO dao = new StudentDAO();
		
		while(run) {
			System.out.println("1.등록 || 2.목록 || 3.단건조회 || 4.수정 || 5.삭제 || 6.종료");
			System.out.print("입력 > ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				System.out.print("이름 > ");
				String name = sc.nextLine();
				System.out.print("이름번호 > ");
				String no = sc.nextLine();
				System.out.print("영어점수 > ");
				int eng = Integer.parseInt(sc.nextLine());
				System.out.print("수학점수 > ");
				int math = Integer.parseInt(sc.nextLine());
				
				Student std = new Student(name, no, eng, math);
				
				if(dao.addStudent(std)) {
					System.out.println("저장되었습니다");
				}else {
					System.out.println("저장 불가");
				}
//				for(int i=0;i<students.length;i++) {
//					if(students[i] ==null) {
//						students[i] = std;
//						break;
//					}
//				}
//				System.out.println("저장되었습니다");
				
				break;
			
			case 2:
//				for (int i = 0; i < students.length; i++) {
//					if(students[i] != null) {
//						students[i].showInfo();
//					}
//				}
				Student[] stdAry = dao.getStudentList();
				for(Student st : stdAry) {
					if(st != null) {
						st.showInfo();
					}
				}
				
				break;
			
			case 3:
				System.out.print("조회할 학생번호 입력 > ");
				no = sc.nextLine();
//				for(int i=0;i<students.length;i++) {
//					if(students[i] != null && students[i].getStudNo().equals(no)) {
//						students[i].showInfo();
//					}
//				}
				Student stnd = dao.getStudent(no);
				if(stnd != null) {
					stnd.showInfo();
				}else {
					System.out.println("존재하지 않는 정보");
				}
				
				break;
				
			case 4:
				System.out.print("수정할 학생번호 > ");
				no = sc.nextLine();
//				for(int i=0;i<students.length;i++) {
//					if(students[i] != null && students[i].getStudNo().equals(no)) {
//						System.out.print("수학점수 > ");
//						students[i].math = Integer.parseInt(sc.nextLine());
//						System.out.print("영어점수 > ");
//						students[i].eng = Integer.parseInt(sc.nextLine());
//					}
//				}
				System.out.print("수학점수 > ");
				math = Integer.parseInt(sc.nextLine());
				System.out.print("영어점수 > ");
				eng = Integer.parseInt(sc.nextLine());
				
				if(dao.modify(no, eng, math)) {
					System.out.println("수정완료");
				}else {
					System.out.println("수정실패");
				}
				break;
				
			case 5:
				System.out.print("삭제할 학생이름 > ");
				name = sc.nextLine();
//				for(int i=0;i<students.length;i++) {
//					if(students[i] != null && students[i].getStudNo().equals(no)) {
//						students[i] = null;
//					}
//				}
				if(dao.remove(name)) {
					System.out.println("삭제완료");
				}else {
					System.out.println("삭제실패");
				}
				
				break;
				
			case 6:
				System.out.println("종료");
				run = false;
				break;
			}
			
		}
		System.out.println("end of prog");
		//
	}

}
