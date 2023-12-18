package com.yedam;

import lombok.Data;

@Data
public class ProductAdmin {
	private int prodCode; //상품코드
	private String prodName; //상품이름
	private int prodPrice; //상품가격
	private int prodCount; //상품재고
	
	ProductAdmin(){
	}
	
	void showprod() {
		System.out.println(this.prodCode+"\t"+this.prodName+"\t"+this.prodPrice +"\t"+this.prodCount);
	}
	
}
