package todo.p20231205;

import lombok.Data;

@Data
public class Product {
	private String prodCode;
	private String prodName;
	private int price;
	
	Product() {
		this.prodCode=prodCode;
		this.prodName=prodName;
		this.price=price;
	}
	Product(String prodCode, String prodName, int price){
		this.prodCode=prodCode;
		this.prodName=prodName;
		this.price=price;
	}
	void prodInfo() {
		System.out.println("상품코드 \t 상품명 \t 가격");
		System.out.println("===========================");
		System.out.println(this.prodCode + "\t" + this.prodName + "\t" + this.price);
	}
}
