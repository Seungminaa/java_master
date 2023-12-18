package com.yedam;

import lombok.Data;

@Data
public class Product {
	private int prodCodes; //고객의 상품코드
	private String prodnames; //주문한 상품들
	private String prodId; //상품받을 사람
	private String prodAddr; //배송위치
	private int prodOQ; //주문수량
	private String prodDate; //상품도착날짜,주문 날짜로부터 3일후
	
	public Product() {
		
	}
	
}
