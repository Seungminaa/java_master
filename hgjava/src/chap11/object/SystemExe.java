package chap11.object;

import java.util.Scanner;

public class SystemExe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System: 1970년 1월 1일 0시
		// 1000 * 60 * 60 * 24
		long dayCut = 1000 * 60 * 60 *24 *365;
		long cur = System.currentTimeMillis(); //현재시점의 Date
		System.out.println(cur);
		System.out.println(cur / dayCut);
		long start = System.currentTimeMillis();
		long sum = 0;
		for(int i=1;i<1000000;i++) {
			sum += i;
		}
		while(true) {
			int a = sc.nextInt();
			if(a==1) {
				break;
			}
		}
		System.out.println("누적합:" + sum);
		long end = System.currentTimeMillis();
		System.out.println("걸린시간:" + (end -start)/1000);
		
	}
}
