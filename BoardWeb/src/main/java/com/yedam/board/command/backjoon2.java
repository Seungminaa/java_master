package com.yedam.board.command;

import java.io.*;
import java.util.*;

public class backjoon2 {
	static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        list = new ArrayList<Integer>();
        
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<a;i++) {
        	list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        //c: 작은값, d:큰값, e:중간값
        
        
            sb.append("\n");
            System.out.println(sb);
        }
    static int get(int key,int low,int high){ 
    	int mid;

    	if(low <= high) {
    		mid = (low + high) / 2;

    		if(key == list.get(mid)) { // 탐색 성공 
    			return mid;
    		} else if(key < list.get(mid)) {
    			// 왼쪽 부분 arr[0]부터 arr[mid-1]에서의 탐색 
    			return get(key ,low, mid-1);  
    		} else {
    			// 오른쪽 부분 - arr[mid+1]부터 arr[high]에서의 탐색 
    			return get(key, mid+1, high); 
    		}
    	}

    	return -1; // 탐색 실패 
    }
}
