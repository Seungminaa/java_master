package chap5;

public class ArrayExe2 {
	public static void main(String[] args) {
		//정수를 담을 수 있는 배열을 생성(크기는 10개의 정수를 저장)
		int[] intAry = new int[10];
		int sum = 0; //50보다 큰 수를 저장
		double avg = 0;
		int count = 0;
		
		for(int i=0;i<intAry.length;i++) {
			intAry[i] = ((i+1)*10);
			System.out.println(intAry[i]);
			if(intAry[i]>50) {
				sum += intAry[i];
				count++;
			}
		}
		// 출력 확장 for구문
		for(int num : intAry) {
			System.out.println(num);
		}
		avg = sum/count;
		System.out.println("50보다 큰 수의 합계 : " + sum);
		System.out.println("50보다 큰 수의 평균 : " + (int)avg);
	}
}
