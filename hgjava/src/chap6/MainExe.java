package chap6;

public class MainExe {
	public static void main(String[] args) {
		
		//싱글톤
		BoardApp app = BoardApp.getInstance();
		BoardApp app1 = BoardApp.getInstance();
		System.out.println(app == app1);
		
		app.start();
		
		
	}
}
