package chap13;

import java.util.*;

public class TypingSpeedGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = "What are you going to do? I will read a book";
		String[] words = word.split(" ");
		List<String> list = new ArrayList<String>();
		for(String str : words) {
			list.add(str);
		}
		long start = System.currentTimeMillis();
		while(list.size() != 0) {
			//목록출력하고
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i) + " / ");
			}
			System.out.println();
			String s = sc.nextLine();
			String[] s1 = s.split(" ");
			for(int j=0;j<list.size();j++) {
				for(int w=0;w<s1.length;w++) {
					if(list.get(j).equals(s1[w])) {
						list.remove(list.get(j));
					}
				}
			}
			//입력값과 목록값과 비교해서 있으면 제거
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start)/1000 + "초 걸림");
		//사용자 입력값과 컬랙션의 값과 비교해서 같은 단어 있으면 삭제
		//시작시머 ~ 종료시간 걸린시간을 초단위로 계산
		//완료하는데 35초가 걸림
	}
}
