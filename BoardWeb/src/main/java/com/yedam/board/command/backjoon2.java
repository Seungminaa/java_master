package com.yedam.board.command;

import java.io.*;
import java.util.*;

public class backjoon2 {
	static int[][] q = new int[30][30];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int i=0;i<a;i++){
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = 0;
            int[] e = new int[2];
            if(c>b){
                e[0] = c; //큰수
                e[1] = b; //작은수
            }else if(c<b){
                e[0] = b;
                e[1] = c;
            }
            d = get(e[0],e[1]);
            
            sb.append(d+"\n");
        }
        System.out.println(sb);
    }
    static int get(int e0,int e1){ //증가량
            if(q[e0][e1] > 0){
                return q[e0][e1];
            }
            if(e0 == e1 || e1==0){
                return q[e0][e1] = 1;
            }

        return q[e0][e1] = get(e0-1,e1-1) + get(e0-1,e1);
    }
}
