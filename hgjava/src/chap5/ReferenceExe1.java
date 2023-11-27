package chap5;

// 복합적인 형태의 데이터 구조
class Friend{
	String name; //필드
	int age; //필드
	double height; //필드
}

public class ReferenceExe1 {
	public static void main(String[] args) {
		
		
		//참조변수: 실제값을 담는것 (X) -> 실제값의 주소
		Friend myFriend = new Friend(); //new => 객체 생성
		
		myFriend.name = "김철수";
		myFriend.age = 20;
		myFriend.height = 178.3;
		
//		Friend ourFriend = myFriend;
//		myFriend.name = "홍길동";
//		
//		System.out.println(ourFriend.name);
//		System.out.println(ourFriend.age);
//		System.out.println(ourFriend.height);
		
		Friend yourFriend = new Friend(); //new => 객체 생성
		
		yourFriend.name = "김철수";
		yourFriend.age = 20;
		yourFriend.height = 178.3;
		
		System.out.println(myFriend == yourFriend); //주소값 비교: false
		
		yourFriend =null;
		System.out.println(myFriend.name);
		try {
			System.out.println(yourFriend.name);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("null 값을 참조합니다");
		}
		
		//기본타입
		int a = 10;
		int b = a;
		
		a = 20;
		
		// 참조타임: 주소값을 변수에 저장
		String name = "신용권"; //주소값은 23dbdae34334 란 값처럼 나옴
		String hobby = "독서";
		
		String name1 = new String("신용권");
		System.out.println("name :" + name);
		System.out.println("name1 :" + name1);
		
		System.out.println(name.equals(name1));
		System.out.println(name == name1); // == -> equals 메소드 활용 
	}
}
