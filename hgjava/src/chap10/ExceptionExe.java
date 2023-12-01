package chap10;

public class ExceptionExe {
	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("end");
	}

	public static void test() throws Exception{
		// 일반예외: 예외를 처리
		Class.forName("java.lang.String2");
	}
}
