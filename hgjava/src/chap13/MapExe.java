package chap13;

import java.util.*;

public class MapExe {
	public static void main(String[] args) {
		// 키 : 값 쌍으로 구성
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		//추가
		map.put("홍길동", 80);
		map.put("김길동", 85);
		map.put("최승민", 90);
		map.put("홍길동", 90);
		
		//value 값
		Integer result = map.get("홍길동");
		
		//전체목록
		Set<String> set = map.keySet();
		for(String key : set) {
			System.out.println("key : " + key + ", value : " + map.get(key));
		}
		
	}
}
