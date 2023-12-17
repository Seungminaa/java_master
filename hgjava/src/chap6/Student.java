package chap6;

public class Student {
	String studNo;
	String name;
	int eng;
	int math;
	void showInfo() {
		System.out.println("학생이름 : " + name);
		System.out.println("학생번호 : " + studNo);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
	}
	String getStudNo() {
		return studNo;
	}
	void setStudNo(String studNo) {
		this.studNo = studNo;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	int getEng() {
		return eng;
	}
	void setEng(int eng) {
		this.eng = eng;
	}
	int getMath() {
		return math;
	}
	void setMath(int math) {
		this.math = math;
	}
	//생성자
	Student(String studNo, String name, int eng, int math) {
		this.studNo = studNo;
		this.name = name;
		this.eng = eng;
		this.math = math;
	}
}
