package chap7.abstracts;

// 추상클래스 : 자식클래스에서 모든기능을 따로 구현
public abstract class Animal {
	private String name;
	
	public Animal() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// 추상메소드
	// 자식 클래스에서 sound() 메소드를 구현해야함
	public abstract void sound();
	
}
