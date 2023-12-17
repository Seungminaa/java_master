package chap11.object;

public class StringExe {
	public static void main(String[] args) {
		String[] fileNames = {"c:/images/prod/sample.jpg", "d:/test/sample/americano.png", "d:/goods/test/2023/moka.jpg"};
		for(String file : fileNames) {
			System.out.println(findFileName(file));
		}
		
		
		String[] numbers = { "980304-1234567","980304-2234567","020101-3456789","020104-4456789","0301053545678"};
		
		for(String no : numbers) {
			System.out.println(findGender(no));
		}
		
		byte[] b1 = "Hello".getBytes();
		for(byte i : b1) {
			System.out.println(i);
		}
		
		//byte 배열을 이어서 String 값으로 만들수 잇음
		String name = new String(new byte[] {65,66,67,68,69});
		name = new String(b1);
		System.out.println(name);
		
		char c1 = name.charAt(0);
		System.out.println(c1);
		
	}
	static String findGender(String ssn) {
		int count =0;
		char re=' ';
		for(int i=0;i<ssn.length();i++) {
			if(ssn.charAt(i)!='-') {
				count++;
			}
			if(count==7) {
				re = ssn.charAt(i);
			}
		}
		String b= "";
		
		switch (re) {
		case '1':
		case '3':
			b = "남";
			break;
		case '2':
		case '4':
			b = "여";
			break;

		}
		return b;
	}
	
	// 파일명을 가져오기
	static String findFileName(String file) {
		String[] files = file.split("/");
		return files[files.length-1];
	}
}
