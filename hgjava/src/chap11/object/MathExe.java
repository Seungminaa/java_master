package chap11.object;

public class MathExe {
	public static void main(String[] args) {
		//long 타입으로 받아야함
		long result = (long)Math.round(-1.2);
		System.out.println(result);
		
		for(int i =1;i<=10;i++) {
			int r = 61 + (int)(Math.random() * 40); // 0 <= x < 10
			System.out.println(r);
		}
		
		// 1 ~ 6 수
		int[] numbers = new int[5];
		// 중복되지 않은 값을 배열에 저장
		for(int i=0;i<numbers.length;i++) {
			boolean run =true;
			while(run) {
				int count =0;
				int r = 1 + (int)(Math.random() * 6); // 0 <= x < 10
				for(int j=0;j<=i;j++) {
					if(numbers[j] == r) {
						count++;
					}
				}
				if(count==0) {
					numbers[i]=r;
					System.out.println(r);
					run = false;
				}
			}
		}
		
	}
}
