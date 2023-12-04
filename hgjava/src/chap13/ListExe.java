package chap13;

import java.util.*;

public class ListExe {
	public static void main(String[] args) {
		
		String[] strs = {"Mon", "Tue", "10"};
		strs[0] = "Wed";
		for(int i=0;i<strs.length;i++) {
			System.out.println(strs[i]);
		}
		
		List<String> list = new ArrayList<String>();
		list.add("Apple");
		list.add("Banana");
		list.add("Cherry");
		
		list.remove("Apple"); //삭제
		list.set(0, "바나나"); //변경
		list.clear(); // 전체요소 제거
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		for(int i=0;i<100;i++) {
			list.add("" + i);
		}
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		// 이름저장
		List<String> names = new ArrayList<String>();
		
		names.add("홍길동"); //0
		names.add("김길동"); //1
		names.add("박철수"); //2
		
		String search = "길동";
		int cnt = 0;
		
		for(int i=0;i<names.size();i++) {
			if(names.get(i).contains(search)) {
				cnt++;
			}
		}
//		for(int i=0;i<names.size();i++) {
//			if(names.get(i).indexOf(search) != -1) {
//				cnt++;
//			}
//		}
		System.out.println(cnt);
		
	}
}
