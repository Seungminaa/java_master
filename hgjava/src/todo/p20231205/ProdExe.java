package todo.p20231205;

import java.util.*;

public class ProdExe {
	static ArrayList<Product> products;
	
	ProdExe() {
		products = new ArrayList<Product>();
		products.add(new Product("P001", "볼펜", 1000));
		products.add(new Product("P002", "연필", 1200));
		products.add(new Product("P001", "노트100", 1000));
		products.add(new Product("P002", "다이어리", 3000));	
	}

	boolean prodAdd(Product products2) {
		
		return products.add(products2);
	}

	boolean prodMod(String prods, int price) {
		String[] prodCdNm = prods.split("/");
		if(prodCdNm.length == 2) {
			for(int i=0;i<products.size();i++) {
				if(products.get(i).getProdCode().equals(prodCdNm[0]) && products.get(i).getProdName().equals(prodCdNm[1])) {
					Product prodMod1 = new Product(prodCdNm[0], prodCdNm[1], price);
					products.set(i, prodMod1);
					return true;
				}
			}
			
		}
		
		return false;
	}

	ArrayList<Product> prodList() {
		return products;
	}
	
	
	
}
