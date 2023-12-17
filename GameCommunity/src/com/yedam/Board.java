package com.yedam;

import java.util.*;

import lombok.Data;

@Data
public class Board {
	private int bNum; //글번호
	private String bName; //글쓴이
	private String bTitle; //글제목
	private String bContent; //글내용
	private Date bDate; //작성시간
	
	Board() {

	}
	Board(int bNum,String bName,String bTitle,String bContent,Date bDate) {
		this.bNum=bNum;
		this.bName=bName;
		this.bTitle=bTitle;
		this.bContent=bContent;
		this.bDate = bDate;
	}

	void showInfo() {
		System.out.println(this.bNum + "\t" + this.bName+ "\t" + this.bTitle);
	}
}
