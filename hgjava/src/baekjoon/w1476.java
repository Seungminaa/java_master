package baekjoon;

import java.io.*;
import java.util.*;

public class w1476 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] d = new int[3];
		d[0] = 1;
		d[1] = 1;
		d[2] = 1;
		
		int count = 1;
		
		while(true) {
			if(a == d[0] && b == d[1] && c==d[2]) {
				break;
			}else {
				d[0]++;
				d[1]++;
				d[2]++;
			}
			
			if(d[0]>15) {
				d[0]=1;
			}
			if(d[1]>28) {
				d[1]=1;
			}
			if(d[2]>19) {
				d[2]=1;
			}
			count++;
		}
		System.out.println(count);
	}
}
