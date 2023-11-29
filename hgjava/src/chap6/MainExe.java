package chap6;

public class MainExe {
	public static void main(String[] args) {
		
		String[] strs = {"1.sad","2.adssad","3.asdad","4.qwe","5.zc","6.zxc","7.vvvv","8.gfg","9.lkj"};
		int page = 1;
		int start = (page -1) * 5;
		int end =page * 5;
		
		for(int i=0;i<strs.length;i++) {
			if(i >=start && i<end) {
				System.out.println(strs[i]);
			}
		}
		
		int cnt = 32;
		
		int totalPage = (int)Math.ceil(cnt/5.0);
		System.out.println(totalPage);
		
		for(int i=1;i<=totalPage;i++) {
			System.out.print(i + " ");
		}
		
	}
}
