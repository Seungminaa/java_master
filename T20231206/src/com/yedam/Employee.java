package com.yedam;

import java.text.*;
import java.util.*;

import lombok.Data;

@Data
public class Employee {
	private String Code;
	private String name;
	private String phone;
	private String day;
	private int pay;
	
	Employee() {
		this.Code=Code;
		this.name=name;
		this.phone=phone;
		this.day=day;
		this.pay=pay;
	}
	Employee(String Code,String name,String phone,String day,int pay) {
		this.Code=Code;
		this.name=name;
		this.phone=phone;
		this.day=day;
		this.pay=pay;
	}
	Employee(String Code,String name,String phone,int pay) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.Code=Code;
		this.name=name;
		this.phone=phone;
		this.day=sdf.format(date);
		this.pay=pay;
	}
	
	void empInfo() {
		System.out.println(this.Code + "\t" + this.name + "\t" + this.phone + "\t" + this.pay);
	}
	void empDateInfo() {
		System.out.println(this.Code + "\t" + this.name + "\t" + this.day);
	}
}
