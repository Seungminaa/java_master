package chap13;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

public class TodoExe {
	public static void main(String[] args) {
		// 순번, 할일(Todo)
		Map<Integer, Todo> todoList = new HashMap<Integer, Todo>();

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("번호 할일 >> ");
			String input = sc.nextLine(); // 20 장보기(엔터)
			String[] inpAry = input.split(" ");
			
			//걸러낼 조건
			if(inpAry.length !=2 && inpAry.length !=3) {
				System.out.println("입력값을 확인하세요");
				continue;
			}
			String order = inpAry[0]; // 순번
			String title = inpAry[1]; // 할일제목

			Todo todo = null;

			if (inpAry.length == 2) {
				todo = new Todo(title);
			} else if (inpAry.length == 3) {
				String dueDate = inpAry[2]; // 날짜
				// Date -> String -> Date
				// 2023-10-23 => format
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					todo = new Todo(title, sdf.parse(dueDate));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			todoList.put(Integer.parseInt(order), todo);

			if (todoList.size() == 3) {
				break;
			}
		}
		// 순번, 할일 출력
		System.out.println("번호 할일 DueDate");
		System.out.println("=======================");
		Set<Entry<Integer, Todo>> entry = todoList.entrySet();
		for (Entry<Integer, Todo> ent : entry) {
			System.out.println(ent.getKey() + " " + ent.getValue().toString());
		}

		System.out.println("end of prog");

	}
}
