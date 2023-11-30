package chap7;


//자식: UnivFriend -> Friend(부모)
public class UnivFriend extends Friend{
	private String univ; //학과
	private String major; //전공
	
	public UnivFriend(String name,String phone, String univ,String major) {
		super(name, phone);
		this.univ=univ;
		this.major=major;
	}
	public UnivFriend() {
		this.major = major;
		this.univ = univ;
	}
	
	
	@Override
	public String showInfo() {
//		return super.showInfo() + ;
		return "이름은 " + getName() + " 연락처는 " + getPhone() + " 학교는 " + getUniv() + " 전공은 " + major;
	}

	public String getUniv() {
		return univ;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
}
