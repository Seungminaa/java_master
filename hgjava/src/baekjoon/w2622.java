package baekjoon;

import java.io.*;
import java.util.*;

public class w2622 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int b = a/3;
		for(int i=1;i<=b;i++) {
			for(int j=i;j<=(a-i)/2;j++) {
				int c=a-i-j;
				if(j>c) {
					break;
				}
				if(c<i+j) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
