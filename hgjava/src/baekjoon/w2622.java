package baekjoon;

import java.io.*;
import java.util.*;

public class w2622 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		
		int b = a/3;
		for(int i=1;i<=b;i++) {
			for(int j=1;j<=a;i++) {
				if(2 *sam(i,j,a-i-j) < a) {
					
				}
			}
		}
	}
	static int sam(int a1,int a2, int a3) {
		int[] as = new int[3];
		as[0] = a1;
		as[1] = a2;
		as[2] = a3;
		Arrays.sort(as);
		return as[2]; //max
	}
}
