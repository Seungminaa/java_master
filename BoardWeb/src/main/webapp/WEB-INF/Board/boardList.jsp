<%@page import="com.yedam.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/menu.jsp"%>
<%@ include file="../layout/nav.jsp"%>
<%
List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList");
%>

<h3>게시판</h3>
<table class='table'>
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일시</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<%
		for (BoardVO vo : list) {
		%>
		<tr>
			<td><%=vo.getBoardNo()%></td>
			<td><a href="getBoard.do?bno=<%=vo.getBoardNo()%>"><%=vo.getTitle()%></a></td>
			<td><%=vo.getWriter()%></td>
			<td><%=vo.getWriteDate()%></td>
			<td><%=vo.getClickCnt()%></td>
		</tr>
		<%
		}
		%>
	</tbody>
</table>
<%@ include file="../layout/foot.jsp"%>
