package chap5;

import java.util.*;

public class StudentApp {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		
		// 1. �л��� 2. �����Է� 3. ������ 4. �м�(�ְ�����, ���) 5. ����
		boolean run = true;
		int[] scores = null;
		int studentNum = 0;
		String[] names = null;
		int max = 0;
		int sum = 0;
		String maxN = "";
		Map<Integer,String> map1 = new HashMap<Integer,String>();
		
		while(run) {
			System.out.println("1.�л��� || 2.�����Է� || 3.������ || 4.�м�(�ְ�����, ���) || 5.����");
			System.out.print("�Է� : ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1 : {
				System.out.print("�л��� �Է� > ");
				studentNum = sc.nextInt();
				scores = new int[studentNum];
				names = new String[studentNum];
				break;
				}
			case 2 : {
				System.out.println("�����Է� > ");
				for(int i=0;i<scores.length;i++) {
					System.out.print("names[" + i + "] >> ");
					names[i] = sc.next();
					System.out.print("scores[" + i + "] >> ");
					scores[i] = sc.nextInt();
				}
				break;
				}
			case 3 : {
				System.out.println("������ > ");
				for(int i=0;i<scores.length;i++) {
					System.out.println("names[" + i + "] >> " + names[i] + ", scores[" + i + "] >> " + scores[i]);
				}
				break;
				}
			case 4 : {
				System.out.println("�м� > ");
				for(int i=0;i<scores.length;i++) {
					sum += scores[i];
					if(max < scores[i]) {
						max = scores[i];
						maxN = names[i];
					}
				}
				System.out.println(maxN + "�� "+"max �� : " + max);
				System.out.println("��� �� : " + (double)sum/scores.length);
				break;
				}
			case 5 : {
				System.out.println("���� > ");
				run = false;
				break;
				}
			}
		}
		System.out.println("end of prog.");
		
	}
}
