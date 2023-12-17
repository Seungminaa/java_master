package com.yedam;

import java.text.SimpleDateFormat;
import java.util.*;

import lombok.Data;

@Data
public class Board extends Member{
	private int bNum; //글번호
	private String bName; //글쓴이
	private String bTitle; //글제목
	private String bContent; //글내용
	private String bDate; //작성시간
	private Date date;
	private SimpleDateFormat sdf;
	
	Board() {

	}
	Board(int bNum,String bName,String bTitle,String bContent,String bDate) {
		this.bNum=bNum;
		this.bName=bName;
		this.bTitle=bTitle;
		this.bContent=bContent;
		this.bDate = bDate;
	}
	Board(String bTitle,String bContent) {
		date = new Date();
		sdf = new SimpleDateFormat("yy-MM-dd");
		this.bName=super.getId();
		this.bTitle=bTitle;
		this.bContent=bContent;
		this.bDate = sdf.format(date);
	}

	void showInfo() {
		System.out.println(this.bNum + "\t" + this.bName+ "\t" + this.bTitle);
	}
	void showDetail() {
		System.out.println("-----------------------------------------------------");
		System.out.println("글번호 | " + this.bNum + "\t 글쓴이 | " + this.bName + "\t 글제목 | " +this.bTitle);
		System.out.println("-----------------------------------------------------");
		System.out.println("글 내용 | " + this.bContent);
		System.out.println("-----------------------------------------------------");
	}
}
