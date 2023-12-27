<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>remBoardForm.jsp</title>
</head>
<body>
	<h3>삭제화면</h3>
	<%
	BoardVO vo = (BoardVO) request.getAttribute("vo");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	%>
	<form name="myForm" action="removeBoard.do">
	<input type="hidden" name="bno" value="<%=vo.getBoardNo()%>">
		<table border="1">
			<tbody>
				<tr>
					<td>글번호</td>
					<td colspan="3"><%=vo.getBoardNo()%></td>
				</tr>
				<tr>
					<td>제목</td>
					<td colspan="3"><%=vo.getTitle()%></td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="3"><%=vo.getContent()%></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td colspan="3"><%=vo.getWriter()%></td>
				</tr>
				<tr>
					<td>작성일</td>
					<td><%=sdf.format(vo.getWriteDate())%></td>
					<td>조회수</td>
					<td><%=vo.getClickCnt()%></td>
				</tr>
				<tr>
					<td>이미지</td>
					<td colspan="3"></td>
				</tr>
				<tr>
					<td colspan="4" align="center"><input type="submit" value="삭제">
						<input type="reset" value="취소"></td>
				</tr>
			</tbody>
		</table>
	</form>
	<br>
	<a href="boardList.do">글목록가기</a>
</body>
</html>