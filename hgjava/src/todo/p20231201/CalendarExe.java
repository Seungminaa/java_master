package todo.p20231201;

import java.util.*;

public class CalendarExe {
	public static void main(String[] args) {
		
		Calendar today = Calendar.getInstance();
		
		//10월 달력 작성
		today.set(2023, 8, 1);
//		today.set(Calendar.MONTH, 9);
//		today.set(Calendar.DATE, 1);
		int num = today.get(Calendar.DAY_OF_WEEK) -1; //일요일부터 1
		String[] days = {"sun","mon","tue","wed","thr","fri","sat"};
		
		for(String day : days) {
			System.out.printf("%4s",day);
		}
		System.out.println();

		for(int i=0;i<num;i++) {
			System.out.printf("%4s"," ");	
		}
		for(int i=1;i<=today.getActualMaximum(today.DATE); i++) {
			System.out.printf("%4d",i);
			if((i+num)%7 == 0){
				System.out.println();
			}
		}
		System.out.println("\n====================");
	}
}
