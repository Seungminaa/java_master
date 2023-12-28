package com.yedam.product.vo;

import lombok.Data;

@Data
public class ProductVO {
	private String productCode; //P2023-01
	private String productName; //이름
	private String productDesc; //설명
	private int originPrice; //가격
	private int salePrice; //할인가격
	private int likeIt; //추천수
	private String image; //이미지
}
