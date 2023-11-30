package chap6;

import java.text.SimpleDateFormat;
import java.util.Date;

//저장소: boards
public class BoardExe {
	static Board[] boards;
	
	BoardExe() {
		//boards = new Board[100];
	}
	{
		boards = new Board[100];
	}
	
	//등록 글번호/제목/작성자/내용/작업일시 => 반환값 : boolean
	public static boolean addBoard(Board board) {
		for(int i=0;i<boards.length;i++) {
			if(boards[i] == null) {
				boards[i] = board;
//				break;//반복문 종료
				return true;
			}
		}
		return false;
	}
	
	//목록 반환값: 배열
	public static Board[] boardList() {
		// boards => 새로운 배열에 정렬된 값으로 변환
		Board temp =null;
			for (int i = 0; i < boards.length-1; i++) {
				for (int j = 0; j < boards.length-1; j++) {
					if(boards[j] != null && boards[j+1] != null) {
						if(boards[j].getBnum() > boards[j+1].getBnum()) {
							temp = boards[j];
							boards[j] = boards[j+1];
							boards[j+1] = temp;
						}
					}
				}
		}
		
		return boards;
	} //end boardList()
	
	//배열, 페이지 => 페이지의 5건을 반환
	public static Board[] pageList(Board[] ary,int page) { //배열, 배열 갯수
		Board[] resultAry = new Board[5];
		int start = (page -1) * 5;
		int end =page * 5;
		int j = 0;
		
		for(int i=0;i<ary.length;i++) {
			if(i >=start && i<end) {
				resultAry[j++] = ary[i];
			}
		}
		return resultAry;
	}
	
	//단건조회 매개변수: 글번호, 반환값: Board
	public static Board getBoard(int no) {
		for(int i=0;i<boards.length;i++) {
			if(boards[i] != null && boards[i].getBnum() == no) {
				return boards[i];
			}
		}
		return null;
	}
	
	//신규번호 : 현재글번호+1
	public static int getSequence() {
		int seqNo = 1;
		// 배열에서 글번호의 max가져오기
		int max = 0;
		for(int i=0;i<boards.length;i++) {
			if(boards[i] != null && boards[i].getBnum() > max) {
				max = boards[i].getBnum();
			}
		}
		seqNo = max + 1;
		return seqNo;
	}
	
	//초기값 생성
	public static void initData() {
		boards[0] = new Board(1,"첫번째 글", "user01","첫번째","2023-11-28");
		boards[1] = new Board(2,"두번째 글", "user02","두번째","2023-11-28");
		boards[2] = new Board(3,"세번째 글", "user03","세번째","2023-11-28");
		boards[3] = new Board(4,"네번째 글", "user04","네번째");
		boards[4] = new Board(5,"다섯번째 글", "user05","다섯번째");
		boards[5] = new Board(6,"여섯번째 글", "user06","여섯번째");
		boards[6] = new Board(7,"일곱번째 글", "user07","일곱번째");
		boards[8] = new Board(8,"여덟번째 글", "user08","여덟번째");
		boards[9] = new Board(9,"아홉번째 글", "user09","아홉번째");
	}
	
	//수정 제목/내용/일시 수정 매개값(글번호, 내용) => boolean
	public static boolean modBoard(int no, String content) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<boards.length;i++) {
			if(no == boards[i].getBnum()) {
				boards[i].setContent(content);
				boards[i].setBtime(sdf.format(date));
				return true;
			}
		}
		return false;
	}
	
	//삭제 매개값(글번호) => boolean
	public static boolean remBoard(int no) {
		for(int i=0;i<boards.length;i++) {
			if(boards[i] != null && no == boards[i].getBnum()) {
				boards[i] = null;
				return true;
			}
		}
		
		return false;
	}
	
	//사용자가 해당글번호의 수정,삭제권한 체크 => boolean
	public static boolean checkResponsibility(String id, int no) {
		for(int i=0;i<boards.length;i++) {
			if(boards[i] != null && boards[i].getBnum() == no && boards[i].getName().equals(id)) {
				return true;
			}
		}
		
		
		return false;
	}
	
	//게시글을 담고 있는 배열에서 값이 있는 건수를 반환
	public static int getBoardCount() {
		int realCnt = 0;
		for(int i=0;i<boards.length;i++) {
			if(boards[i] != null) {
				realCnt++;
			}
		}
		return realCnt;
	}
	
}
