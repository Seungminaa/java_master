package chap1;

import java.io.*;
import java.util.*;

public class Hello {

	public static void main(String[] args) throws IOException{
		System.out.println("Hello java");
		
		int x = 5;
		int y = x + 10;
		System.out.println(y);
		
		double z = 3.5;
		System.out.println(z);
		System.out.print("y = " + y);
		
		//변수의 값 교환
		x = 3;
		y = 10;
		int c = x;
		x = y;
		y = c;
		
		System.out.println("x = " + x + "y = " + y);
		
		//기본타입
		//크기순서 : bite < short < char(음수x) < int < long
		
		char charData = 'A';
		int intData = charData;
		
		System.out.println("char : " + charData + ", int : " + intData);
		
		char c1 = 'a';
		int c2 = c1 + 2; //자동타입 변환
		
		char c3 = (char)c2; //강제타입 변환
		System.out.println(c2 + ", c3 : " + c3);
		System.out.printf("c2 : %10d, c3 : %s \n",c2,c3);
		
		x = 5;
		y = 2;
		double result = (double)x / y;
		System.out.println(result);
		
		double v1 = 3.5;
		double v2 = 2.7;
		int result2 = (int)(v1 + v2);
		System.out.println(result2);
		
		long var1 = 2L;
		float var2 = 1.8f;
		double var3 = 2.5;
		String var4 = "3.9";
		int result3 = (int)(var1 + var2 + var3) + (int)(Double.parseDouble(var4));
		System.out.println(result3);
		
		//표준입력 : 키보드 => System.in.read()
		//한글자만 읽어들임
		
//		int keyCode;
//		while(true) {
//			keyCode = System.in.read();
//			System.out.println("keyCode : " + keyCode);
//			if(keyCode == 113) {
//				break;
//			}
//		}
//		System.out.println("종료");
		
		//문자열 입력 -> Scanner -> 객체를 생성해서 사용
		String scinput;
		
		Scanner sc = new Scanner(System.in);
		while(true){
		System.out.print("이름입력 : ");
		scinput = sc.nextLine();
		
			if(scinput.equals("q")) {
				break;
			}
		System.out.println("내 이름은 " + scinput);
		}
		System.out.println("종료");
		
		System.out.print("수입력 : ");
		scinput = sc.nextLine();
		System.out.println(Integer.parseInt(scinput) + 10);
		
		
		
		
		
		
		
		
		
		
		sc.close();
	} //end main

} // end class