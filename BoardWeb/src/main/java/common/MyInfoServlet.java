package common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MyInfoServlet")
public class MyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MyInfoServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8"); //타입을 html로 변환
		
		//파라미터 확인
		// ?sno=23-010&sname=승민&escore=80&mscore=50
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String escore = request.getParameter("escore");
		String mscore = request.getParameter("mscore");
		
		System.out.println("sno : " + sno + ",sname : " + sname + ",escore : " + escore + ",mscore : " + mscore);
		
		//db 저장
		Student std = new Student(sno, sname, Integer.parseInt(escore), Integer.parseInt(mscore));
		StudentDAO dao = new StudentDAO();
		boolean done = dao.addStudent(std);
		
		dao.addStudent(std);
		
		PrintWriter out = response.getWriter();
		out.append("Served at: ").append(request.getContextPath());
		out.println("<h3>Welcome Servlet, 안녕</h3>");
		out.println("<a href='index.html'>인덱스이동</a>");
		
		if(done) {
			out.println("<script>alert('OK'); location.href='student/studentList.jsp';</script>");
		}else {
			out.println("<script>alert('Fail'); location.href='index.html';</script>");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
