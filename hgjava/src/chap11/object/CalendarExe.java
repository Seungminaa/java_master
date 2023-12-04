package chap11.object;

import java.util.*;

public class CalendarExe {
	public static void main(String[] args) {
		//1. Year 2. Month / DAY_OF_WEEK: 일(1) 월(2) ...토(7)
		Calendar cal = Calendar.getInstance();
		cal.set(1, 2022);
		cal.set(Calendar.MONTH, 4);
		cal.set(Calendar.DATE, 1);
		cal.set(2023, 2, 1);
		System.out.println("년도:" + cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("막날: " + cal.getActualMaximum(Calendar.DATE));
	}
}
