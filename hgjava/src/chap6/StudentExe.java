package chap6;
//저장공간:배열
//추가,수정,삭제,목록,단건조회
public class StudentExe {
	//배열
	private Student[] students;
	
	//생성자
	StudentExe() {
		students = new Student[100];
		students[0] = new Student("23-001", "홍길동", 77, 88);
		students[1] = new Student("23-002", "김철수", 82, 85);
	}
	
	//추가
	boolean addStudent(Student std) {
		for(int i=0;i<students.length;i++) {
			if(students[i] ==null) {
				students[i] = std;
				return true; //메소드에서 return 문은 메소드의 끝
			}
		}
		return false;
	}
	
	//목록
	Student[] getStudentList() {
		return students;
	}
	
	//단건조회
	Student getStudent(String no) {
		for(int i=0;i<students.length;i++) {
			if(students[i] != null && students[i].getStudNo().equals(no)) {
				return students[i];
			}
		}
		return null;
	}
	
	//수정
	boolean modify(String no, int eng, int mat) {
		for(int i=0;i<students.length;i++) {
			if(students[i] != null && students[i].getStudNo().equals(no)) {
				System.out.print("수학점수 > ");
				students[i].setMath(mat);
				System.out.print("영어점수 > ");
				students[i].setEng(eng);
				return true;
			}
		}
		return false;
	}
	
	//삭제
	boolean remove(String no) {
		for(int i=0;i<students.length;i++) {
			if(students[i] != null && students[i].getStudNo().equals(no)) {
				students[i] = null;
				return true;
			}
		}
		return false;
	}
	
	
	
}
