package chap5;

public class ArrayExe3 {
	public static void main(String[] args) {
		String[] nameAry = {"È«±æµ¿","±è±æµ¿","¹Ú±æµ¿","°í±æµ¿","È«±æµ¿"};
		
		String search = "È«±æµ¿";
		int count = 0;
		
		for(String n : nameAry) {
			if(n.equals(search)) {
				count++;
			}
		}
		System.out.println(search + "Àº ÃÑ " + count + "¸í ÀÔ´Ï´Ù.");
		int[] scores = {88, 68, 72, 89, 92, 70};
		int maxScore = 0;
		
		for(int n : scores) {
			if(maxScore < n) {
				maxScore = n;
			}
		}
		System.out.println(maxScore);
	}
}
