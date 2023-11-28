package chap6;

public class Board {

	private int bnum;
	private String title;
	private String name;
	private String content;
	private String btime;
	
	Board() {
		
	}
	
	Board(int bnum,String title,String name,String content,String btime){
		this.bnum=bnum;
		this.title=title;
		this.content=content;
		this.name=name;
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
	
	
}