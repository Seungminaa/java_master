package chap5;

import java.util.*;

public class StudentApp {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		
		// 1. 학생수 2. 점수입력 3. 목록출력 4. 분석(최고점수, 평균) 5. 종료
		boolean run = true;
		int[] scores = null;
		int studentNum = 0;
		String[] names = null;
		int max = 0;
		int sum = 0;
		String maxN = "";
		Map<Integer,String> map1 = new HashMap<Integer,String>();
		
		while(run) {
			System.out.println("1.학생수 || 2.점수입력 || 3.목록출력 || 4.분석(최고점수, 평균) || 5.종료");
			System.out.print("입력 : ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1 : {
				System.out.print("학생수 입력 > ");
				studentNum = sc.nextInt();
				scores = new int[studentNum];
				names = new String[studentNum];
				break;
				}
			case 2 : {
				System.out.println("점수입력 > ");
				for(int i=0;i<scores.length;i++) {
					System.out.print("names[" + i + "] >> ");
					names[i] = sc.next();
					System.out.print("scores[" + i + "] >> ");
					scores[i] = sc.nextInt();
				}
				break;
				}
			case 3 : {
				System.out.println("목록출력 > ");
				for(int i=0;i<scores.length;i++) {
					System.out.println("names[" + i + "] >> " + names[i] + ", scores[" + i + "] >> " + scores[i]);
				}
				break;
				}
			case 4 : {
				System.out.println("분석 > ");
				for(int i=0;i<scores.length;i++) {
					sum += scores[i];
					if(max < scores[i]) {
						max = scores[i];
						maxN = names[i];
					}
				}
				System.out.println(maxN + "의 "+"max 값 : " + max);
				System.out.println("평균 값 : " + (double)sum/scores.length);
				break;
				}
			case 5 : {
				System.out.println("종료 > ");
				run = false;
				break;
				}
			}
		}
		System.out.println("end of prog.");
		
	}
}
