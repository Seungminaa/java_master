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
	//Data lombok이 가지고 있는 hashCode,equals 정의는 값이 모두 동일할때 같은 값으로 판단
	//hashCode, equals 정의하는 지에 따라서 동일객체
//	@Override
//	public int hashCode() {
//		return super.hashCode();
//	}
}
