package miniPrj;

import lombok.Data;

@Data
public class Board {
	private int bNum; //글번호
	private String bName; //글쓴이
	private String bTitle; //글제목
	private String bContent; //글내용
	private String bDate; //작성시간
	
	Board() {

	}
}
