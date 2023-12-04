package chap13;

import java.util.*;

public class ListExe2 {
	public static void main(String[] args) {
		List<Member> members = new ArrayList<>();
		members.add(new Member("M-001","홍길동",1000));
		members.add(new Member("M-002","김길동",1500));
		members.add(new Member("M-003","최인수",2000));
		String search = "길동";
		int cnt = 0;
		for (int i = 0; i < members.size(); i++) {
			if(members.get(i).getMemberName().indexOf(search) !=-1 && members.get(i).getPoint() >=1500) {
				cnt++;
				members.remove(i);
			}
		}
		
		for(Member mem : members) {
			System.out.println(mem);
		}
		
	}
}
