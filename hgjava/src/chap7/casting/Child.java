package chap7.casting;

public class Child extends Parent{
	private String phone;
	
	@Override
	String showInfo() {
		// TODO Auto-generated method stub
		return super.showInfo() + " - " + phone;
	}
}
