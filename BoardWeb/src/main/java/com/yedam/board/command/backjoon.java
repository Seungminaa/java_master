package com.yedam.board.command;

import java.io.*;

public class backjoon {
    static int a,c;
    static int[] b;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = Integer.parseInt(br.readLine());

        b = new int[223];

        for(int i=0;i<b.length;i++){
            b[i] = (i+1) * (i+1);
        }
        c = 5;
        int count = 0; // 횟수
        int a1 = 0; // 합계
        
        for(int i=0;i<b.length;i++) {
        	get(i,1);
        }
        System.out.println(c);
    }
    static int get(int c,int count){ //누적값을 받아 계산
        
        for(int i=0;i<b.length;i++){
            if(b[i]+c == a){
                if(c>count){
                    c=count;
                }
                return b[i] + c;
            } else if(b[i]+c < a){
                return get(b[i]+c, count++);
            }
        }
        return 0;
    }
}
