package chap7;

//Friend 상속 + 회사, 부서
public class CompFriend extends Friend{
	private String company;
	private String dept;
	
	public CompFriend(String name, String phone, String company,String dept) {
		super(name, phone); // super: 부모클래스를 상속
		this.company =company;
		this.dept=dept;
	}
	@Override
	public String showInfo() {
//		return super.showInfo() + ;
		return "이름은 " + getName() + " 연락처는 " + getPhone() + " 회사는 " + getCompany() + " 부서는 " + getDept();
	}
	
	//getter, setter
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
}
