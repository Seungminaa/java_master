package chap5;

public class ArrayExe2 {
	public static void main(String[] args) {
		//������ ���� �� �ִ� �迭�� ����(ũ��� 10���� ������ ����)
		int[] intAry = new int[10];
		int sum = 0; //50���� ū ���� ����
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
		// ��� Ȯ�� for����
		for(int num : intAry) {
			System.out.println(num);
		}
		avg = sum/count;
		System.out.println("50���� ū ���� �հ� : " + sum);
		System.out.println("50���� ū ���� ��� : " + (int)avg);
	}
}
