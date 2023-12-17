package miniPrj;

import lombok.Data;

@Data
public class Member {
	private String id; //접속 아이디
	private String passwd; //접속 비밀번호
	private int point; //계정이 가지고 있는 포인트
	
	Member() {

	}
	
	Member(String id,String pw) {
		this.id=id;
		this.passwd=pw;
	}
}
