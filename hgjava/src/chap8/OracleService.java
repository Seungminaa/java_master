package chap8;

public class OracleService implements DatabaseService{

	@Override
	public void add() {
		System.out.println("Oracle 입력처리");
	}

	@Override
	public void modify() {
		System.out.println("Oracle 수정처리");
		
	}

	@Override
	public void remove() {
		System.out.println("Oracle 삭제처리");
		
	}
	
}
