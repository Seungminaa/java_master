package common;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/studentList")
public class StudentListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public StudentListServ() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8"); //타입을 html로 변환
		PrintWriter out = response.getWriter();
		
		//목록 페이지
		StudentDAO dao = new StudentDAO();
		List<Student> list = dao.getStudentList();
		
//		out.print("<table border='1'>");
		String str = "<table border='1'>";
		str += "<thead><tr><th>학생번호</th><th>학생이름</th><th>영어등수</th><th>수학등수</th></tr></thead>";
		str += "<tbody>";
		for(Student std : list) {
			str += "<tr><td><a href='getStudentServlet?sno="+std.getStudNo()+"'>" + std.getStudNo() + "</td>"+"<td>" + std.getName() + "</td>"+"<td>" + std.getEng() + "</td>"+"<td>" + std.getMath() + "</td></tr>";
		}
		str += "</tbody></table>";
		str += "<a href='student/inform.html'>인포테이블로 이동</a>";
		out.print(str);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
