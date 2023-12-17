package todo.p20231127;

public class MemberService {

	boolean login(String id, String pw) {
		if(id.equals("hong") && pw.equals("12345")) {
			return true;
		}
		return false;
	}

	void logout(String id) {
		System.out.println("로그아웃 되었습니다");
	}

}
