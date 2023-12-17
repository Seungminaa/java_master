package todo.p20231205;

import java.util.*;

public class ProdApp {
	static Scanner sc = new Scanner(System.in);
	static ProdExe exe = new ProdExe();
	static InOutExe exe1 = new InOutExe();
	static Map<String, Integer> map = new HashMap<String, Integer>();
	public static void main(String[] args) {
		boolean run = true;
		
		while(run) {
			System.out.println("1.상품관리 / 2.입출고관리 / 3.종료");
			System.out.println("====================");
			System.out.print("입력 > ");
			int menu1 = sc.nextInt();
			
			switch (menu1) {
			case 1:
				System.out.println("1-1)등록 / 1-2)수정 / 1-3)목록 / 1-4)취소");
				System.out.println("====================");
				System.out.print("입력 > ");
				int menu2 = sc.nextInt();
				switch (menu2) {
				case 1:
					System.out.print("등록할 상품코드 > ");
					String prodCode = sc.next();
					System.out.print("등록할 상품명 > ");
					String prodName = sc.next();
					System.out.print("등록할 상품가격 > ");
					int price = sc.nextInt();
					
					Product products = new Product(prodCode, prodName, price);
					if(exe.prodAdd(products)) {
						System.out.println("등록완료");
					}else {
						System.out.println("등록실패");
					}
					break;
				
				case 2:
					System.out.println("수정할 상품코드 / 상품명( /로 나눔) > ");
					String prods = sc.next();
					System.out.print("수정될 상품가격 > ");
					price = sc.nextInt();
					if(exe.prodMod(prods, price)) {
						System.out.println("수정완료");
					}else {
						System.out.println("수정실패(상품코드 및 상품명을 확인해주세요)");
					}
					break;
				
				case 3:
					for(Product b : exe.prodList()) {
						b.prodInfo();
					}
					break;
				
				case 4:
					continue;

				}
				
				break;
			
			case 2:
				System.out.println("2-1)판매 / 2-2)구매 / 2-3)재고 / 2-4)판매정보 2-5)취소");
				System.out.println("====================");
				System.out.print("입력 > ");
				int menu3 = sc.nextInt();
				switch (menu3) {
				case 1:
					System.out.println("판매할 상품코드 > ");
					String prodCode = sc.next();
					System.out.println("판매할 수량 > ");
					int num = sc.nextInt();
					InOut inouts = new InOut(prodCode, num, "판매");
					if(exe1.prodSellAdd(inouts)) {
						System.out.println("판매완료");
					}else {
						System.out.println("잘못된 등록");
					}
					break;
				
				case 2:
					System.out.println("구매할 상품코드 > ");
					prodCode = sc.next();
					System.out.println("구매할 수량 > ");
					num = sc.nextInt();
					inouts = new InOut(prodCode, num, "구매");
					if(exe1.prodSellAdd(inouts)) {
						System.out.println("구매완료");
					}else {
						System.out.println("잘못된 등록");
					}
					break;
				
				case 3:
					System.out.println("상품코드 \t 가격");
					System.out.println("===========================");
					for(InOut b : exe1.prodSum()) {
						b.stock();
					}
					break;
					
				case 4:
					
					break;
				
				case 5:
					continue;
				}
				
				break;

			case 3:
				run =false;
				System.out.println("종료");
				break;

			
			}
			
		}
		
	}
}
