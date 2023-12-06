package com.yedam;

import java.util.ArrayList;

public class EmpDAO {
	static ArrayList<Employee> employees;

	EmpDAO() {
		employees = new ArrayList<Employee>();
		employees.add(new Employee("23-11", "홍길동", "943-1234", "2023-10-01", 300));
		employees.add(new Employee("23-12", "김길동", "943-1244", "2023-10-01", 300));
		employees.add(new Employee("23-13", "박길동", "943-1254", "2023-10-01", 300));
	}

	boolean addList(Employee data) {
		return employees.add(data);
	}

	ArrayList<Employee> viewList() {
		return employees;
	}

	boolean empMod(String total) {
		String[] share = total.split(" ");
		boolean wer = false;
		try {
		if (share.length == 2 && Integer.parseInt(share[1]) >= 0) {
			for (int i = 0; i < employees.size(); i++) {
					if (employees.get(i).getCode().equals(share[0])) {
						employees.get(i).setPay(Integer.parseInt(share[1]));
						wer = true;
					}
			}
		}
		} catch (Exception e) {
			return false;
		}
		 return wer;
	}

	boolean empDel(String code) {
		boolean yn = false;
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getCode().equals(code)) {
				employees.remove(i);
				yn = true;
			}
		}
		return yn;
	}

	ArrayList<Employee> dateList(String day) {
		ArrayList<Employee> dateEmp = new ArrayList<Employee>();
		String[] newDates = day.split("-");
		
		if(newDates.length ==3) {
			for(int i=0;i<employees.size();i++) {
				String[] oldDates = employees.get(i).getDay().split("-");
				if(Integer.parseInt(oldDates[0]) >= Integer.parseInt(newDates[0]) &&  Integer.parseInt(oldDates[1]) >= Integer.parseInt(newDates[1]) && Integer.parseInt(oldDates[2]) >= Integer.parseInt(newDates[2]) && Integer.parseInt(newDates[1])<=12 && Integer.parseInt(newDates[2])<=31) {
					dateEmp.add(employees.get(i));
				}
			}
		}else {
			System.out.println("날짜 입력이 잘못되었습니다");
		}
		
		return dateEmp;
	}

}
