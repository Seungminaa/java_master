package chap13;

import lombok.Data;

@Data
public class Member {
	private String memberNo;
	private String memberName;
	private int point;
	
	public Member(String memberNo,String memberName,int point) {
		this.memberNo=memberNo;
		this.memberName=memberName;
		this.point=point;
	}
}
