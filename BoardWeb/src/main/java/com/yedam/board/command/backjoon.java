package com.yedam.board.command;

import java.util.*;

public class backjoon {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		Map<Integer, Integer> a = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < 8; i++) {
			int c = sc.nextInt();
			a.put(c,i);
		}
		List<Integer> b = new ArrayList<Integer>(a.keySet());
		b.sort((s1, s2) -> s2.compareTo(s1));
		
		int c=0;
		int[] d = new int[5];
		
		for(int i=0;i<5;i++) {
			c += b.get(i);
			for (int key : a.keySet()) {
				if (key == b.get(i)) {
	                d[i] = a.get(key) + 1;
	                break;
	            }
			}
		}
		Arrays.sort(d);
		sb.append(c + "\n");
		
		for(int w : d) {
			sb.append(w+" ");
		}
		System.out.println(sb);
	}
}
