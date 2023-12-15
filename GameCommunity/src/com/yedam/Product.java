package com.yedam;

import lombok.Data;

@Data
public class Product {
	private String prodName; //상품이름
	private int prodPrice; //상품가격
	private String prodDate; //상품도착날짜,주문 날짜로부터 3일후
	private String prodAddr; //배송위치
	
	public Product() {

	}
}
