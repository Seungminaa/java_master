package chap11.object;

import java.util.*;

public class HashSetExe {
	public static void main(String[] args) {
		// 배열 -> 컬렉션(List, Set, Map)
		//set: 중복된 값을 담지 않음
		HashSet<String> set = new HashSet<String>();
		set.add("Hong");
		set.add("Hwang");
		set.add("Park");
		set.add("Hong");
		
		for(String name : set) {
			System.out.println(name);
		}
		//hashcode 값이 동등한지 비교해서 중복된 값 제거
		HashSet<Member> members = new HashSet<Member>();
		members.add(new Member("홍길동", 20));
		members.add(new Member("김길동", 21));
		members.add(new Member("박길동", 22));
		members.add(new Member("홍길동", 20));
		
		for(Member name : members) {
			System.out.println(name.toString());
		}
	}
}
