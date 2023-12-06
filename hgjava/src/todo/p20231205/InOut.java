package todo.p20231205;

import java.text.*;
import java.util.*;

import lombok.Data;

@Data
public class InOut {
	Date date = new Date();
	private String buySell;
	private String prodCode;
	private int prodNum;
	private String date2;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	InOut() {
		this.buySell=buySell;
		this.prodCode=prodCode;
		this.prodNum=prodNum;
		this.date2=sdf.format(date);
	}

	
	InOut(String prodCode,int prodNum,String buySell) {
		this.buySell=buySell;
		this.prodCode=prodCode;
		this.prodNum=prodNum;
		this.date2=sdf.format(date);
	}
	void stock() {
		System.out.println("상품코드 \t 가격");
		System.out.println("===========================");
		System.out.println(this.prodCode + "\t" + this.prodNum);
	}
}
