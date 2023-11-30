package chap6;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Board {

	private int bnum;
	private String title;
	private String name;
	private String content;
	private String btime;
	
	//변경되었습니다.

	//나도 변경해야지
	public Board() {
		
	}
	
	public Board(int bnum,String title,String name,String content){
		Date today = new Date(); //시스템 시간을 기준으로 생성
//		int year = today.getYear();
//		int month = today.getMonth()+1;
//		int date = today.getDate();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		this.bnum=bnum;
		this.title=title;
		this.content=content;
		this.name=name;
		this.btime = sdf.format(today);
	}

	public Board(int bnum,String title,String name,String content,String btime){
		// this(); //기본생성자
		this(bnum,title,name,content);
		this.btime=btime;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBtime() {
		return btime;
	}
	public void setBtime(String btime) {
		this.btime = btime;
	}
	public void showInfo() {
		System.out.println("번호 : " + bnum);
		System.out.println("제목 : " + title);
	}
	public void showDetail() {
		System.out.println("제목 : " + title);
		System.out.println("작성자 : " + name);
		System.out.println("내용 : " + content);
		System.out.println("작성일시 : " + btime);
	}
	
}
