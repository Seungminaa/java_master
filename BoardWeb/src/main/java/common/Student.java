package common;

public class Student {
	String studNo; //stud_no
	String name; // 
	int eng;
	int math;
	public Student(){
		
	}
	public void showInfo() {
		System.out.println("학생이름 : " + name);
		System.out.println("학생번호 : " + studNo);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
	}
	public String getStudNo() {
		return studNo;
	}
	public void setStudNo(String studNo) {
		this.studNo = studNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	//생성자
	public Student(String studNo, String name, int eng, int math) {
		this.studNo = studNo;
		this.name = name;
		this.eng = eng;
		this.math = math;
	}
}
