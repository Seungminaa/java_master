package baekjoon;

import java.io.*;

public class w2018 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		
		int b=0;
		int c=0;
		
		while(true) {
			if(c>a) {
				break;
			}else {
				c++;
			}
			int d=0;
			for(int i = c;i<=a;i++) {
				if(a==d) {
					b++;
					d+=i;
				}else {
					d+=i;
				}
				if(a<d) {
					break;
				}
			}
		}
		System.out.println(b+1);
	}
}
